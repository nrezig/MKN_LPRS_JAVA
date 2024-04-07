package com.example.java_mkn_lprs.modele;

public class DossierInscription {

    private int id;



    private FicheEtudiant ficheEtudiant;
    private String filiere;

    private String motivation;


    public DossierInscription(FicheEtudiant ficheEtudiant) {
        this.ficheEtudiant = ficheEtudiant;
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

    // Setters
    public void setFiliere(String filiere) { this.filiere = filiere; }
    public void setFicheEtudiant(FicheEtudiant fiche) { this.ficheEtudiant = fiche; }


}
