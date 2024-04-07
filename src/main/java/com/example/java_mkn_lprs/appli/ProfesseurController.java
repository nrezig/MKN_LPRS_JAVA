package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DossierInscription;
import com.example.java_mkn_lprs.modele.FicheEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfesseurController {

    @FXML
    private TableView<DossierInscription> tableView;

    @FXML
    private TableView<DossierInscription> tableViewDossiers;
    @FXML
    private TableColumn<DossierInscription, String> colNom;
    @FXML
    private TableColumn<DossierInscription, String> colPrenom;
    @FXML
    private TableColumn<DossierInscription, String> colFiliere;
    @FXML
    private TableColumn<DossierInscription, String> colDernierDiplome;
    @FXML
    private TableColumn<DossierInscription, String> colEmail;

    @FXML
    private TableColumn<DossierInscription, String> colTelephone;

    @FXML
    private TableColumn<DossierInscription, String> colAdresse;

    @FXML
    private Label labelNomPrenom;
    @FXML
    private Label labelFiliere;
    @FXML
    private Label labelDernierDiplome;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelTelephone;
    @FXML
    private Label labelMotivation;
    @FXML
    private Label labelAdresse;

    @FXML
    private Button btnVoirDetails;


    @FXML
    public void initialize() {

        loadDossierData();

    }



    @FXML
    private void voirDossiers() {
        try {
            HelloApplication.redirectToViewDossiers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Charge les données des dossiers d'inscription  et les affiche dans la TableView.*/
    @FXML
    private void loadDossierData() {
        ObservableList<DossierInscription> dossierData = FXCollections.observableArrayList();
        String SQL = "SELECT e.id as idFicheEtudiant, e.nom, e.prenom, e.dernier_diplome, e.email, e.telephone, e.adresse, d.filiere FROM ficheetudiant e JOIN dossierinscription d ON e.id = d.ref_ficheEtudiant;";

        try (Connection conn = bdd.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

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
                dossier.setFiliere(rs.getString("filiere"));
                dossierData.add(dossier);
            }

            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
            colDernierDiplome.setCellValueFactory(new PropertyValueFactory<>("dernierDiplome"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));


            tableViewDossiers.setItems(dossierData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Gère l'action du bouton pour voir les détails du dossier sélectionné.
     Affiche une alerte si aucun dossier n'est sélectionné.
     */
    @FXML
    private void handleVoirDetailsAction() {
        DossierInscription selectedDossier = tableViewDossiers.getSelectionModel().getSelectedItem();
        if (selectedDossier != null) {
            voirDetailsDossier(selectedDossier.getId());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucun dossier sélectionné");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un dossier pour afficher les détails.");
            alert.showAndWait();
        }
    }

    /* Affiche les détails d'un dossier sélectionné en fonction de son ID.
     @param idDossier ID du dossier dont les détails doivent être affichés.
     */
    public void voirDetailsDossier(int idDossier) {
        String SQL = """
        SELECT f.nom, f.prenom, f.dernier_diplome, f.email, f.telephone, f.adresse, d.filiere, d.motivation
        FROM ficheetudiant AS f
        JOIN dossierinscription AS d ON f.id = d.ref_ficheEtudiant
        WHERE d.id = ?;
        """;

        try (Connection conn = bdd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, idDossier);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                labelNomPrenom.setText(rs.getString("nom") + " " + rs.getString("prenom"));
                labelFiliere.setText(rs.getString("filiere"));
                labelDernierDiplome.setText(rs.getString("dernier_diplome"));
                labelEmail.setText(rs.getString("email"));
                labelTelephone.setText(rs.getString("telephone"));
                labelAdresse.setText(rs.getString("adresse"));
                labelMotivation.setText(rs.getString("motivation"));
            } else {
                clearDossierDetails();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Lorqu'aucun dossier n'est sélectionné*/

    private void clearDossierDetails() {
        labelNomPrenom.setText("...");
        labelFiliere.setText("..");
        labelDernierDiplome.setText("...");
        labelEmail.setText("...");
        labelTelephone.setText("...");
        labelAdresse.setText("...");
        labelMotivation.setText("...");
    }


}

