package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.FicheFourniture;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class DemandeFournitureController {

    @FXML
    private TextField champsfourniture;

    @FXML
    private TextField champsquantite;

    @FXML
    private TextField champsraison;

    @FXML
    private Button validerbouton;

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

    public DemandeFournitureController() throws Exception {
    }

    @FXML
    private void onValiderButtonClick() throws Exception {
        // Récupérez les valeurs des champs texte
        String fourniture = champsfourniture.getText();
        String quantite = champsquantite.getText();
        String raison = champsraison.getText();

        Connection maConnexion = bdd.getConnection();

            String query = "INSERT INTO demandefourniture (fourniture_demande, quantite_demande, raison, valide, ref_ficheFourniture, ref_professeur) VALUES (?, ?, ?, 0, 1, 1)";
            PreparedStatement preparedStatement = maConnexion.prepareStatement(query);
                preparedStatement.setString(1, fourniture);
                preparedStatement.setString(2, quantite);
                preparedStatement.setString(3, raison);
                preparedStatement.executeUpdate();


        // Redirigez l'utilisateur vers la vue prof_acceuil
        HelloApplication.sceneConnexion("Prof_acceuil");
    }
}
