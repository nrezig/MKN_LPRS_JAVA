package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;


public class UpdateUserController {

    @FXML
    private TextField nomUpUser;

    @FXML
    private TextField prenomUpUser;

    @FXML
    private TextField EmailUpUser;

    @FXML
    private TextField MdpUpUser;

    @FXML
    private ComboBox<String> Profil;

    Connection maConnexion = bdd.getConnection();


    public UpdateUserController() throws Exception {
    }


    public void initialize()throws Exception{
        ObservableList<Utilisateur> userSelectedData = HelloApplication.getUserSelectedData();


        if (!userSelectedData.isEmpty()) {
            Utilisateur utilisateur = userSelectedData.get(0);
            nomUpUser.setText(utilisateur.getNom());
            prenomUpUser.setText(utilisateur.getPrenom());
            EmailUpUser.setText(utilisateur.getEmail());
            MdpUpUser.setText(utilisateur.getMdp());
            String [] items = {"Administrateur", "Professeur", "Secretaire", "Gestionnaire de stock"};
            Profil.getItems().addAll(items);
        }
    }



    @FXML
    void UpdateUser(ActionEvent event) throws SQLException {
        String data = Profil.getSelectionModel().getSelectedItem();
        int selectedUserId = HelloApplication.getSelectedUserId();
        PreparedStatement update = maConnexion.prepareStatement("UPDATE users SET nom = ?, prenom = ?, email = ?, password = ?, profil = ? WHERE id = ?");
        update.setString(1, nomUpUser.getText());
        update.setString(2, prenomUpUser.getText());
        update.setString(3, EmailUpUser.getText());
        update.setString(4, MdpUpUser.getText());
        update.setString(5, data);
        update.setInt(6, selectedUserId);
        System.out.println(selectedUserId);
        update.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout !");
        alert.setContentText("L'utilisateur "+ nomUpUser.getText() +" "+ prenomUpUser.getText() +" a été modifié avec succés ! Actualisé pour voir les changements !");
        alert.showAndWait();

        HelloApplication.sceneConnexion("Admin_acceuil");
    }
}
