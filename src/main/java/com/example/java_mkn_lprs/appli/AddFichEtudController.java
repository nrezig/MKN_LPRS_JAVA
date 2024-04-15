package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddFichEtudController {
    @FXML
    private TextField nomFiche;

    @FXML
    private TextField prenomFiche;

    @FXML
    private TextField EmailFiche;

    @FXML
    private TextField TelFiche;

    @FXML
    private TextField AdresseFiche;

    @FXML
    private TextField DiplomeFiche;

    Connection maConnexion = bdd.getConnection();
    Utilisateur user = new Utilisateur();


    public AddFichEtudController() throws Exception {
    }

    @FXML
    void AddFicheEtudiant(ActionEvent event) throws Exception{
        PreparedStatement insert = maConnexion.prepareStatement("INSERT INTO ficheetudiant (nom, prenom,  dernier_diplome, email, telephone, adresse, ref_secretaire) VALUES (?,?,?,?,?,?,?);");
        insert.setString(1,nomFiche.getText());
        insert.setString(2,prenomFiche.getText());
        insert.setString(3, DiplomeFiche.getText());
        insert.setString(4, EmailFiche.getText());
        insert.setString(5, TelFiche.getText());
        insert.setString(6, AdresseFiche.getText());
        insert.setInt(7, Utilisateur.getUtilisateurConnecteId());
        insert.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout !");
        alert.setContentText("La fiche de l'étudiant "+ nomFiche.getText() +" "+ prenomFiche.getText() +" a été enregistrée avec succés ! Actualisé pour voir les changements !");
        alert.showAndWait();

        HelloApplication.sceneConnexion("FichesEtudiantsList");
    }

    }


