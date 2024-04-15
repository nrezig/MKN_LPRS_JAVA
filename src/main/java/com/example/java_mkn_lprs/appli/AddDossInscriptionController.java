package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.FicheEtudiant;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddDossInscriptionController {
    @FXML
    private DatePicker Date;

    @FXML
    private TextField Heure;

    @FXML
    private TextField Filliere;

    @FXML
    private TextArea Motivation;
    Connection maConnexion = bdd.getConnection();

    public AddDossInscriptionController() throws Exception {
    }


    @FXML
    void AddDossInscription(ActionEvent event) throws Exception{
        try{
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH':'mm");
            java.util.Date heureDate =  inputFormat.parse(Heure.getText());
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            String heureFormatted = outputFormat.format(heureDate);
            PreparedStatement insert = maConnexion.prepareStatement("INSERT INTO dossierinscription (date, heure, filiere, motivation, ref_ficheEtudiant, ref_secretaire) VALUES(?,?,?,?,?,?)");
            insert.setDate(1, java.sql.Date.valueOf(Date.getValue()));
            insert.setString(2, heureFormatted);
            insert.setString(3, Filliere.getText());
            insert.setString(4, Motivation.getText());
            insert.setInt(5, FicheEtudiant.getSelectedFicheId());
            insert.setInt(6, Utilisateur.getUtilisateurConnecteId());
            insert.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout !");
            alert.setContentText("Le dossier d'incription  a été créé avec succés ! Actualisé pour voir les changements !");
            alert.showAndWait();

            HelloApplication.sceneConnexion("FichesEtudiantsList");

        }catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setContentText("Veuillez saisir l'heure au format 'HH:mm', par exemple '10:00'.");
            alert.showAndWait();
        }


    }

}
