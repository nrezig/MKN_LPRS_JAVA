package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DossierInscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfesseurController {
    @FXML
    private TableView<DossierInscription> tableViewDossiers;
    @FXML
    private TableColumn<DossierInscription, String> colNom, colPrenom, colFiliere, colDernierDiplome, colEmail, colTelephone, colAdresse;

    public void initialize() {
        System.out.println("Initializing ProfesseurController...");

        if (colNom == null) {
            System.out.println("colNom is null!");
        }
        if (tableViewDossiers == null) {
            System.out.println("tableViewDossiers is null!");
        }

        // Configure table columns and load data if everything is correctly injected
        if (colNom != null && tableViewDossiers != null) {
            configureTableColumns();
            loadDossierData();
        } else {
            System.out.println("FXML components are not injected correctly!");
        }
    }

    private void configureTableColumns() {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        colDernierDiplome.setCellValueFactory(new PropertyValueFactory<>("dernierDiplome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
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
    private void loadDossierData() {
        configureTableColumns();

        ObservableList<DossierInscription> dossierData = FXCollections.observableArrayList();
        String SQL = "SELECT e.id, e.nom, e.prenom, e.dernier_diplome, e.email, e.telephone, e.adresse, d.filiere FROM ficheetudiant e JOIN dossierinscription d ON e.id = d.ref_ficheEtudiant;";
        try (Connection conn = bdd.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                dossierData.add(new DossierInscription(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("filiere"),
                        rs.getString("dernier_diplome"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("adresse")
                ));
            }
            tableViewDossiers.setItems(dossierData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onDossierSelected() {
        DossierInscription dossierSelected = tableViewDossiers.getSelectionModel().getSelectedItem();
        if(dossierSelected != null) {
            HelloApplication.redirectToViewDossiersDetail(dossierSelected);
        }
    }
}
