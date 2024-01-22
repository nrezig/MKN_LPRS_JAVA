package com.example.java_mkn_lprs.modele;

public class FicheFourniture {
    private int id_fichefourniture;
    private String libelle;
    private String description;
    private String quantite;

    public int getId_fichefourniture() {
        return id_fichefourniture;
    }

    public void setId_fichefourniture(int id_fichefourniture) {
        this.id_fichefourniture = id_fichefourniture;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
    public FicheFourniture(int id_fichefourniture, String libelle, String description, String quantite){
        this.id_fichefourniture = id_fichefourniture;
        this.libelle = libelle;
        this.description = description;
        this.quantite = quantite;
    }

}
