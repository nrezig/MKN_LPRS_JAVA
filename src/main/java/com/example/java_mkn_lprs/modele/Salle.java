package com.example.java_mkn_lprs.modele;

public class Salle {
    private int id;
    private String numero;
    private boolean disponible;

    public Salle(int id, String numero, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.disponible = disponible;
    }

    public int getId() { return id; }
    public String getNumero() { return numero; }
    public boolean isDisponible() { return disponible; }

    @Override
    public String toString() {
        return "Salle " + numero + (disponible ? " (Disponible)" : " (Occupée)");
    }
}
