package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnexionController {
    @FXML
    private TextField email;

    @FXML
    private Button login;

    @FXML
    private Button oublie;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button retour;

    @FXML
    void login(ActionEvent event) throws Exception {
        HelloApplication.sceneConnexion("hello-view");

        UtilisateurController uneConnexion = new UtilisateurController();
        uneConnexion.connexion(email.getText(), mdp.getText());
    }
    @FXML
    void oublie(ActionEvent event) {
        HelloApplication.sceneConnexion("mdp_oublie");
    }
    @FXML
    void retour(ActionEvent event){
        HelloApplication.sceneConnexion("hello-view");
    }

}
