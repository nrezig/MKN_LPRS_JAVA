package com.example.java_mkn_lprs.modele;

import javafx.collections.ObservableList;

public class FicheEtudiant {
    private int id_fiche;
    private String nom;
    private String prenom;
    private String dernier_diplome;
    private String email;
    private String telephone;
    private String adresse;

    private static ObservableList<FicheEtudiant> ficheSelectedData;
    public static ObservableList<FicheEtudiant> getFicheSelectedData() {
        return ficheSelectedData;
    }
    public static void setFicheSelectedData(ObservableList<FicheEtudiant> ficheSelectedData) {
        FicheEtudiant.ficheSelectedData = ficheSelectedData;
    }

    private static int selectedFicheId;
    public static int getSelectedFicheId() {
        return selectedFicheId;
    }
    public static void setSelectedFicheId(int selectedFicheId) {
        FicheEtudiant.selectedFicheId = selectedFicheId;
    }

    public FicheEtudiant(int id_fiche, String nom, String prenom, String dernier_diplome, String email, String telephone, String adresse) {
        this.id_fiche = id_fiche;
        this.nom = nom;
        this.prenom = prenom;
        this.dernier_diplome = dernier_diplome;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    // Getters


    public int getId_fiche() { return id_fiche; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }

    public String getDernier_diplome() { return dernier_diplome;}

    public String getEmail() { return email; }

    public String getTelephone() { return telephone; }

    public String getAdresse() { return adresse; }

    // Setters
    public void setIdFicheEtudiant(int id) { this.id_fiche = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDernierDiplome(String diplome) { this.dernier_diplome = diplome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String tel) { this.telephone = tel; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}