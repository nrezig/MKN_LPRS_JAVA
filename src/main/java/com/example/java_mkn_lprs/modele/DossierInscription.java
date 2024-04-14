package com.example.java_mkn_lprs.modele;

import com.example.java_mkn_lprs.appli.DossierInscriptionController;

public class DossierInscription {
    private static int dossier;
    private int id;

    private FicheEtudiant ficheEtudiant;
    private String filiere;

    private String motivation;


    public DossierInscription(int id, String nom, String prenom, String filiere, String dernierDiplome, String email, String telephone, String adresse) {
        this.id = id;
        this.filiere = filiere;
        this.ficheEtudiant = new FicheEtudiant(id, nom, prenom, dernierDiplome, email, telephone, adresse);
        dossier=id;
    }


    // Getters

    public int getId() {
        return id;
    }
    public String getNom() { return ficheEtudiant.getNom(); }
    public String getPrenom() { return ficheEtudiant.getPrenom(); }
    public String getDernierDiplome() { return ficheEtudiant.getDernierDiplome(); }
    public String getEmail() { return ficheEtudiant.getEmail(); }
    public String getTelephone() { return ficheEtudiant.getTelephone(); }
    public String getFiliere() { return filiere; }

    public String getMotivation() { return motivation; }


    public String getAdresse() {
        return ficheEtudiant.getAdresse();
    }

    public static int getDossier() {
        return dossier;
    }

    // Setters
    public void setFiliere(String filiere) { this.filiere = filiere; }
    public void setFicheEtudiant(FicheEtudiant fiche) { this.ficheEtudiant = fiche; }

}
