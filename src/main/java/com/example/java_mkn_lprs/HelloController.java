package com.example.java_mkn_lprs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class HelloController {
    @FXML
    private Button login;

    @FXML
    void showLogin(ActionEvent event) {
        HelloApplication.sceneConnexion("Connexion");
    }



}