package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.FicheEtudiant;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateFichEtudController {
    @FXML
    private TextField nomUpFiche;

    @FXML
    private TextField prenomUpFiche;

    @FXML
    private TextField EmailUpFiche;

    @FXML
    private TextField TelUpFiche;

    @FXML
    private TextField AdresseUpFiche;

    @FXML
    private TextField DiplomeUpFiche;

    Connection maConnexion = bdd.getConnection();

    public UpdateFichEtudController() throws Exception {
    }


    public void initialize(){
        ObservableList<FicheEtudiant> ficheSelectedData = FicheEtudiant.getFicheSelectedData();

        if(!ficheSelectedData.isEmpty()){
            FicheEtudiant ficheEtudiant = ficheSelectedData.get(0);
            nomUpFiche.setText(ficheEtudiant.getNom());
            prenomUpFiche.setText(ficheEtudiant.getPrenom());
            EmailUpFiche.setText(ficheEtudiant.getEmail());
            TelUpFiche.setText(ficheEtudiant.getTelephone());
            AdresseUpFiche.setText(ficheEtudiant.getAdresse());
            DiplomeUpFiche.setText(ficheEtudiant.getDernier_diplome());
        }
    }

    @FXML
    void UpdateFicheEtudiant(ActionEvent event) throws Exception{
        int selectedFicheId = FicheEtudiant.getSelectedFicheId();
        PreparedStatement update = maConnexion.prepareStatement("UPDATE ficheetudiant SET nom = ?, prenom = ?, dernier_diplome = ?, email = ?, telephone = ?, adresse = ? WHERE id = ?");
        update.setString(1, nomUpFiche.getText());
        update.setString(2, prenomUpFiche.getText());
        update.setString(3, DiplomeUpFiche.getText());
        update.setString(4, EmailUpFiche.getText());
        update.setString(5, TelUpFiche.getText());
        update.setString(6, AdresseUpFiche.getText());
        update.setInt(7, selectedFicheId);
        update.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification !");
        alert.setContentText("La fiche de l'étudiant "+ nomUpFiche.getText() +" "+ prenomUpFiche.getText() +" a été modifiée avec succés ! Actualisé pour voir les changements !");
        alert.showAndWait();

        HelloApplication.sceneConnexion("FichesEtudiantsList");

    }

}
