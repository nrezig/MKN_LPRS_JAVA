package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.modele.DossierInscription;
import com.example.java_mkn_lprs.modele.Salle;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class RendezVousControlleur {

    @FXML
    private Button btnVoirDossiers;

    @FXML
    private DatePicker date;

    @FXML
    private Label labelBienvenue;

    @FXML
    private ComboBox<Integer> salle;

    @FXML
    private VBox sidebar;

    @FXML
    private Button valider;
    @FXML
    private Label message;
    @FXML
    void loadDossierData(ActionEvent event) {

    }

    @FXML
    void onClickValider(ActionEvent event) throws Exception {
        String date = this.date.getValue() + "";
        System.out.println(date);
        String salle = this.salle.getValue() + "";
        System.out.println(salle);
        PreparedStatement req = bdd.getConnection().prepareStatement("SELECT COUNT(r.id) FROM rendezvous as r INNER JOIN salle as s  ON r.ref_salle= s.id WHERE date_rendez_vous = ? and s.id = ?");
        req.setString(1, date);
        req.setString(2, salle);
        ResultSet res = req.executeQuery();

        if (res.next()){
            System.out.println(res.getInt(1));

            if (res.getInt(1) >= 2) {
                message.setText("Il y a déjà 2 rendez-vous organiser se jour là !");
            } else {
                PreparedStatement rq = bdd.getConnection().prepareStatement("INSERT INTO rendezvous(date_rendez_vous, ref_dossierInscription, ref_professeur, ref_salle) VALUES (?,?,?,(SELECT id FROM salle WHERE numero=?))");
                rq.setString(1, date);
                rq.setInt(2, DossierInscription.getDossier());
                rq.setInt(3, Utilisateur.getId());
                rq.setInt(4, Integer.parseInt(salle));
                int rs = rq.executeUpdate();
                message.setText("Le rendez-vous a bien été planifié");
            }
        }
    }

    @FXML
    public void initialize() {
        try {
            // Préparez la requête pour sélectionner tous les numéros de salle
            PreparedStatement rq = bdd.getConnection().prepareStatement("SELECT numero FROM salle");
            ResultSet rs = rq.executeQuery();

            // Parcourez les résultats et ajoutez chaque numéro de salle à la liste déroulante
            while (rs.next()) {
                salle.getItems().add(rs.getInt("numero"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Gérez l'exception de manière appropriée (log, message d'erreur, etc.)
        }
    }
}




