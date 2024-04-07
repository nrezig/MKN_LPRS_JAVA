package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddUserController {
    @FXML
    private AnchorPane emailNewUser;

    @FXML
    private TextField nomNewUser;

    @FXML
    private TextField prenomNewUser;

    @FXML
    private TextField EmailNewUser;

    @FXML
    private TextField MdpNewUser;


    @FXML
    private ComboBox<String> Profil;

    @FXML
    private Label selection;



    Connection maConnexion = bdd.getConnection();

    public AddUserController() throws Exception {
    }

    public void initialize(){
        String [] items = {"Administrateur","Professeur", "Secretaire", "Gestionnaire de Stock"};
        Profil.getItems().addAll(items);

    }


    @FXML
    void AddUser(ActionEvent event) throws SQLException {
        String data = Profil.getSelectionModel().getSelectedItem();

        PreparedStatement insert = maConnexion.prepareStatement("INSERT INTO users (nom, prenom,email, password, profil) VALUES (?,?,?,?,?);");
        insert.setString(1,nomNewUser.getText());
        insert.setString(2,prenomNewUser.getText());
        insert.setString(3, EmailNewUser.getText());
        insert.setString(4, MdpNewUser.getText());
        if(data.equals("Professeur")){
            insert.setString(5, "Professeur");
        } else if (data.equals("Secretaire")) {
            insert.setString(5, "Secretaire");
        } else if (data.equals("Gestionnaire de stock")) {
            insert.setString(5, "Gestionnaire de stock");
        } else if (data.equals("Administrateur")) {
            insert.setString(5, "Administrateur");
        }

        insert.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout !");
        alert.setContentText("L'utilisateur "+ nomNewUser.getText() +" "+ prenomNewUser.getText() +" a été créee avec succés ! Actualisé pour voir les changements !");
        alert.showAndWait();

        HelloApplication.sceneConnexion("Admin_acceuil");
    }

    @FXML
    void showProfil(ActionEvent event) {

    }



}
