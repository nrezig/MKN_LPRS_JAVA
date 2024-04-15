package com.example.java_mkn_lprs.modele;

import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PrimitiveIterator;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class DossierInscription {

    private int id;

    private FicheEtudiant ficheEtudiant;
    private String filiere;

    private String motivation;
    private Date date;
    private String heure;

    private static final SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");

    public String getHeureFormatted() {
        try {
            Date heureDate = heureFormat.parse(heure);
            return heureFormat.format(heureDate);
        } catch (ParseException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("La saisie ne corespond pas au formet attendu !");
            alert.showAndWait();
          return null;
        }
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) throws ParseException{
        heureFormat.setLenient(false);
        heureFormat.parse(heure);
        this.heure = heure;
    }

    public DossierInscription(int id, String nom, String prenom, String filiere, String dernierDiplome, String email, String telephone, String adresse) {
        this.id = id;
        this.filiere = filiere;
        this.ficheEtudiant = new FicheEtudiant(id, nom, prenom, dernierDiplome, email, telephone, adresse);

    }


    // Getters

    public int getId() {
        return id;
    }
    public String getNom() { return ficheEtudiant.getNom(); }
    public String getPrenom() { return ficheEtudiant.getPrenom(); }
    public String getDernierDiplome() { return ficheEtudiant.getDernier_diplome(); }
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
