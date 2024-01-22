package com.example.java_mkn_lprs.modele;

public class DemandeFourniture {
    private int id_demande;
    private String raison;
    private String quantite_demande;
    private String fourniture_demande;
    private boolean valide;

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getQuantite_demande() {
        return quantite_demande;
    }

    public void setQuantite_demande(String quantite_demande) {
        this.quantite_demande = quantite_demande;
    }

    public String getFourniture_demande() {
        return fourniture_demande;
    }

    public void setFourniture_demande(String fourniture_demande) {
        this.fourniture_demande = fourniture_demande;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
    public DemandeFourniture(int id_demande, String raison, String quantite_demande, String fourniture_demande, boolean valide){
        this.id_demande = id_demande;
        this.quantite_demande = quantite_demande;
        this.fourniture_demande = fourniture_demande;
        this.raison = raison;
        this.valide = valide;
    }
}
