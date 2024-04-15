package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DemandeFourniture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import BDD.bdd;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AfficherDemandeController {

    public Button id_retour;
    @FXML
    private TableView<DemandeFourniture> DemandeFourniture;
    @FXML
    private TableColumn<DemandeFourniture, String> prof_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> raison_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> quantite_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> fourniture_colonne;
    @FXML
    private TableColumn<DemandeFourniture, Boolean> valide_colonne;

    @FXML
    private Button validerbouton;
    Connection maConnexion = bdd.getConnection();

    public AfficherDemandeController() throws Exception {
    }


    @FXML
    public void ask_fourniture(javafx.event.ActionEvent actionEvent) {
        HelloApplication.sceneConnexion("demande_fourniture");
    }

    @FXML
    public void show_fourniture(javafx.event.ActionEvent actionEvent) {
        HelloApplication.sceneConnexion("show_demande");
    }

    @FXML
    private void voirDossiers() {
        try {
            HelloApplication.redirectToViewDossiers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() throws Exception {
        prof_colonne.setCellValueFactory(new PropertyValueFactory<>("id"));
        raison_colonne.setCellValueFactory(new PropertyValueFactory<>("raison"));
        quantite_colonne.setCellValueFactory(new PropertyValueFactory<>("quantite_demande"));
        fourniture_colonne.setCellValueFactory(new PropertyValueFactory<>("fourniture_demande"));
        afficherDemandes();
    }

    private void afficherDemandes() throws Exception {
        maConnexion = bdd.getConnection();
        String query = "SELECT * FROM demandefourniture";
        PreparedStatement rq = maConnexion.prepareStatement(query);
        ResultSet rs = rq.executeQuery();

        while (rs.next()) {
            int id_demande = rs.getInt("id");
            String raison = rs.getString("raison");
            String quantite_demande = rs.getString("quantite_demande");
            String fourniture_demande = rs.getString("fourniture_demande");
            boolean valide = rs.getBoolean("valide");

            DemandeFourniture demande = new DemandeFourniture(id_demande, raison, quantite_demande, fourniture_demande, valide);
            DemandeFourniture.getItems().add(demande);
            }
    }


}