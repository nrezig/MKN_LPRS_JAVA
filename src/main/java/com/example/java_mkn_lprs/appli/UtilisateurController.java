package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilisateurController {
    public Utilisateur connexion (String email, String mdp ) throws Exception {
        Connection maConnexion = bdd.getConnection();
        Utilisateur unUser = new Utilisateur();


        PreparedStatement login = maConnexion.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?;");
        login.setString(1, email);
        login.setString(2, mdp);
        ResultSet result = login.executeQuery();

        if (result.next()){
            unUser.setNom(result.getString("nom"));
            unUser.setPrenom(result.getString("prenom"));
            Utilisateur.setId(result.getInt("id"));
            unUser.setEmail(result.getString("email"));
            unUser.setProfil(result.getString("profil"));


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés !");
            alert.setContentText("Connexion réussie !");
            alert.showAndWait();
            if(result.getString("profil").equals("Admin")){
                HelloApplication.sceneConnexion("Admin_acceuil");
            }
            else if (result.getString("profil").equals("Professeur")){
                HelloApplication.sceneConnexion("Prof_acceuil");
            }
            else if (result.getString("profil").equals("secretaire")) {
                HelloApplication.sceneConnexion("Secretaire_acceuil");
            }
            else if (result.getString("profil").equals("Gestionnaire de stock")) {
                HelloApplication.sceneConnexion("GS_acceuil");
            }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("MAIL OU MOT DE PASSE INCORRET !!");
            alert.showAndWait();
            HelloApplication.sceneConnexion("Connexion");
        }


        return null;
    }




}
