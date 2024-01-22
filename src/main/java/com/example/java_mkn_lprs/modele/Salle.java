package com.example.java_mkn_lprs.modele;

public class Salle {
    private int id_salle;
    private String numero;
    private boolean disponible;

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public Salle (int id_salle, String numero, boolean disponible){
        this.id_salle = id_salle;
        this.numero = numero;
        this.disponible = disponible;
    }
}
