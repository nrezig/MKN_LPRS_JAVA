package com.example.java_mkn_lprs.modele;

public class FicheEtudiant {
    private int idFicheEtudiant;
    private String nom;
    private String prenom;
    private String dernierDiplome;
    private String email;
    private String telephone;
    private String adresse;

    public FicheEtudiant(int idFicheEtudiant, String nom, String prenom, String dernierDiplome, String email, String telephone, String adresse) {
        this.idFicheEtudiant = idFicheEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.dernierDiplome = dernierDiplome;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    // Getters
    public int getIdFicheEtudiant() { return idFicheEtudiant; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getDernierDiplome() { return dernierDiplome; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getAdresse() { return adresse; }

    // Setters
    public void setIdFicheEtudiant(int id) { this.idFicheEtudiant = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDernierDiplome(String diplome) { this.dernierDiplome = diplome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String tel) { this.telephone = tel; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}