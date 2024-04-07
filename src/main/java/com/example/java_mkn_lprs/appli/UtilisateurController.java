package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilisateurController {
    public Utilisateur connexion(String email, String mdp) throws Exception {
        Connection maConnexion = bdd.getConnection();
        Utilisateur unUser = null;

        PreparedStatement login = maConnexion.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?;");
        login.setString(1, email);
        login.setString(2, mdp);
        ResultSet result = login.executeQuery();

        if (result.next()) {
            unUser = new Utilisateur();
            unUser.setNom(result.getString("nom"));
            unUser.setPrenom(result.getString("prenom"));
            unUser.setId(result.getInt("id")); // Correction ici
            unUser.setEmail(result.getString("email"));
            unUser.setProfil(result.getString("profil"));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès !");
            alert.setContentText("Connexion réussie !");
            alert.showAndWait();

            switch (result.getString("profil")) {
                case "Admin":
                    HelloApplication.sceneConnexion("Admin_acceuil");
                    break;
                case "professeur":
                    HelloApplication.sceneConnexion("Prof_acceuil");
                    break;
                case "secretaire":
                    HelloApplication.sceneConnexion("Secretaire_acceuil");
                    break;
                case "gestionnaireStock":
                    HelloApplication.sceneConnexion("GS_acceuil");
                    break;
                default:
                    throw new IllegalStateException("Profil inconnu: " + result.getString("profil"));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("EMAIL OU MOT DE PASSE INCORRECT !!");
            alert.showAndWait();
            HelloApplication.sceneConnexion("Connexion");
        }

        return unUser;
    }
}
