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
        PreparedStatement login = maConnexion.prepareStatement("SELECT * FROM users  WHERE email = ? AND password = ?;");
        login.setString(1, email);
        login.setString(2, mdp);
        ResultSet result = login.executeQuery();

        if (result.next()){
            Utilisateur unUser = new Utilisateur(result.getInt("id"), result.getString("nom"), result.getString("prenom"),
                    result.getString("email"), result.getString("password"), result.getString("profil"));
            Utilisateur.setUtilisateurConnecteId(unUser.getId());


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés !");
            alert.setContentText("Connexion réussie !");
            alert.showAndWait();
            if(result.getString("profil").equals("Administrateur")){
                HelloApplication.sceneConnexion("Admin_accueil");
            }
            else if (result.getString("profil").equals("Professeur")){
                HelloApplication.sceneConnexion("Prof_acceuil");
            }
            else if (result.getString("profil").equals("Secretaire")) {
                HelloApplication.sceneConnexion("Secretaire_accueil");
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
