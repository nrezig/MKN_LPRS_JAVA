package com.example.java_mkn_lprs.modele;

public class FicheEtudiant {
    private int idFicheEtudiant;
    private String nom;
    private String prenom;
    private String dernierDiplome;
    private String email;
    private String telephone;
    private String adresse;

    public FicheEtudiant(int idFicheEtudiant, String nom, String prenom, String dernierDiplome) {
        this.idFicheEtudiant = idFicheEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.dernierDiplome = dernierDiplome;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public int getIdFicheEtudiant() {
        return idFicheEtudiant;
    }

    public void setIdFicheEtudiant(int idFicheEtudiant) {
        this.idFicheEtudiant = idFicheEtudiant;
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

    public String getDernierDiplome() {
        return dernierDiplome;
    }

    public void setDernierDiplome(String dernierDiplome) {
        this.dernierDiplome = dernierDiplome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
