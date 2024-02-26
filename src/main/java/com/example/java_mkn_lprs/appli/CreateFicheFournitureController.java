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


public class CreateFicheFournitureController {

    @FXML
    public Button id_boutonV_fichefourniture;

    @FXML
    private TextField id_desc_fichefourniture;

    @FXML
    private TextField id_quantite_fichefourniture;

    @FXML
    private TextField id_libelle_fichefourniture;

    @FXML
    void retour(ActionEvent event) {
        HelloApplication.sceneConnexion("Prof_acceuil");
    }

    public CreateFicheFournitureController() throws Exception {
    }

    @FXML
    private void onValiderButtonClick() throws Exception {
        // Récupérez les valeurs des champs texte
        String description = id_desc_fichefourniture.getText();
        String libelle = id_libelle_fichefourniture.getText();
        String quantite = id_quantite_fichefourniture.getText();

        Connection maConnexion = bdd.getConnection();

        String query = "INSERT INTO fichefourniture (libelle, description, quantite, ref_gestionnaireStock) VALUES (?, ?, ?, 1)";
        PreparedStatement preparedStatement = maConnexion.prepareStatement(query);
        preparedStatement.setString(1, libelle);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, quantite);
        preparedStatement.executeUpdate();


        // Redirigez l'utilisateur vers la vue prof_acceuil
        HelloApplication.sceneConnexion("Prof_acceuil");
    }
}
