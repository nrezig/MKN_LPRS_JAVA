package com.example.java_mkn_lprs.modele;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class Utilisateur {
    private static int id;

    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String profil;

    @FXML

    private Label labelBienvenue;


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Utilisateur.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setEmail(String email) {

        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (email.matches(regex)) {
            this.email = email;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR !");
            alert.setContentText("ADRESSE MAIL NON COMFORME !");
            alert.showAndWait();

        }
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

}
