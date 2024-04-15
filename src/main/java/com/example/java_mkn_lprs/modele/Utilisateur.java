package com.example.java_mkn_lprs.modele;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String profil;
    @FXML
    private Label labelBienvenue;

    public Utilisateur(int id, String nom, String prenom, String email, String mdp,  String profil) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;

    }
    public Utilisateur(){

    }
    private static ObservableList<Utilisateur> userSelectedData;
    public static void setUserSelectedData(ObservableList<Utilisateur> data) {
        userSelectedData = data;
    }
    public static ObservableList<Utilisateur> getUserSelectedData() {
        return userSelectedData;
    }
    private static int selectedUserId;
    public static int getSelectedUserId() {
        return selectedUserId;
    }

    public static void setSelectedUserId(int userId) {
        selectedUserId = userId;
    }
    private static int utilisateurConnecteId;

    public static void setUtilisateurConnecteId(int id) {
        utilisateurConnecteId = id;
    }

    public static int getUtilisateurConnecteId() {
        return utilisateurConnecteId;
    }





    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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