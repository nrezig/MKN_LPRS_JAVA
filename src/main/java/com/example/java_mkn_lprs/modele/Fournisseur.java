package com.example.java_mkn_lprs.modele;

public class Fournisseur {
    private int id_fournisseur;
    private String nom;

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Fournisseur(int id_fournisseur, String nom){
        this.id_fournisseur = id_fournisseur;
        this.nom = nom;
    }
}
