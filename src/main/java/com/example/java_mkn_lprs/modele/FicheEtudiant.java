package com.example.java_mkn_lprs.modele;

import javafx.scene.control.Alert;

public class FicheEtudiant {

    private String nom;
    private String prenom;
    private String dernier_diplome;
    private String email;
    private String telephone;
    private String adresse;
    private static int id_ficheetudiant;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDernier_diplome() {
        return dernier_diplome;
    }

    public void setDernier_diplome(String dernier_diplome) {
        this.dernier_diplome = dernier_diplome;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    public static int getId() {
        return id_ficheetudiant;
    }

    public static void setId(int id) {
        FicheEtudiant.id_ficheetudiant = id;
    }

    public FicheEtudiant (int id, String nom, String prenom, String email, String telephone, String adresse){
        this.id_ficheetudiant = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }


}
