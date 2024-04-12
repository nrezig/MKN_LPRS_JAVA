package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DossierInscription;
import com.example.java_mkn_lprs.modele.FicheEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.security.auth.callback.Callback;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfesseurController {

    @FXML
    private TableView<DossierInscription> tableViewDossiers;

    @FXML
    private TableColumn<DossierInscription, String> colNom, colPrenom, colFiliere, colDernierDiplome;

    @FXML
    private Button btnDetail;

    @FXML
    private TableColumn<DossierInscription, DossierInscription> colAction;

    @FXML
    public void initialize() throws Exception {
        loadDossierData();
    }

    @FXML
    private void voirDossiers(ActionEvent event) {
        HelloApplication.redirectToViewDossiers();
    }

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.sceneConnexion("Prof_acceuil");
    }

    @FXML
    void ask_fourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("demande_fourniture");
    }

    @FXML
    void show_fourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("show_demande");
    }

    @FXML
    void create_fichefourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("Create_fichefourniture");
    }


    @FXML
    private void loadDossierData() throws Exception {
        ObservableList<DossierInscription> dossierData = FXCollections.observableArrayList();
        String SQL = "SELECT e.id as idFicheEtudiant, e.nom, e.prenom, d.filiere, e.dernier_diplome, e.email, e.telephone, e.adresse FROM ficheetudiant e JOIN dossierinscription d ON e.id = d.ref_ficheEtudiant;";

         Connection conn = bdd.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            FicheEtudiant ficheEtudiant = new FicheEtudiant(
                    rs.getInt("idFicheEtudiant"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("dernier_diplome"),
                    rs.getString("email"),
                    rs.getString("telephone"),
                    rs.getString("adresse")
            );

            DossierInscription dossier = new DossierInscription(ficheEtudiant);
            dossier.setFiliere(rs.getString("filiere")); // Set other properties as needed
            dossierData.add(dossier);
        }

        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        colDernierDiplome.setCellValueFactory(new PropertyValueFactory<>("dernierDiplome"));

        tableViewDossiers.setItems(dossierData);
    }

    @FXML
    private void voirDetailsDossier(DossierInscription event) {
        DossierInscription dossierSelectionne = tableViewDossiers.getSelectionModel().getSelectedItem();
        if (dossierSelectionne != null) {
            HelloApplication.redirectToViewDossiersDetail(dossierSelectionne);
        }
    }




}
