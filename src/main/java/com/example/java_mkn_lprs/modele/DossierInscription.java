package com.example.java_mkn_lprs.modele;

import java.sql.Time;
import java.util.Date;

public class DossierInscription {
    private int id_dossier;
    private Date date;
    private Time heure;
    private String  filiere;
    private String motivation;

    public int getId_dossier() {
        return id_dossier;
    }

    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
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
    public DossierInscription (int id_dossier, Date date, Time heure, String filiere, String motivation){
        this.id_dossier = id_dossier;
        this.date = date;
        this.heure = heure;
        this.filiere = filiere;
        this.motivation = motivation;
    }
}
