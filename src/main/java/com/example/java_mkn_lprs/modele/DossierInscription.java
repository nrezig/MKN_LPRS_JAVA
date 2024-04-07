package com.example.java_mkn_lprs.modele;

import java.sql.Time;
import java.util.Date;

public class DossierInscription {
    private int idDossier;
    private Date date;
    private Time heure;
    private String filiere;
    private String motivation;

    private FicheEtudiant ficheEtudiant;


    public DossierInscription(int idDossier, Date date, Time heure, String filiere, String motivation) {
        this.idDossier = idDossier;
        this.date = date;
        this.heure = heure;
        this.filiere = filiere;
        this.motivation = motivation;
    }

    public DossierInscription(FicheEtudiant ficheEtudiant) {
        this.ficheEtudiant = ficheEtudiant;
    }



    public DossierInscription(String nom, String prenom, String filiere, String dernierDiplome) {
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public FicheEtudiant getFicheEtudiant() {
        return ficheEtudiant;
    }

    public void setFicheEtudiant(FicheEtudiant ficheEtudiant) {
        this.ficheEtudiant = ficheEtudiant;
    }

    public String getNom() {
        return this.ficheEtudiant.getNom();
    }

    public String getPrenom() {
        return this.ficheEtudiant.getPrenom();
    }

    public String getDernierDiplome() {
        return this.ficheEtudiant.getDernierDiplome();
    }

}
