package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.modele.DossierInscription;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DossiersDetailController {
    @FXML
    private Label labelNomPrenom, labelFiliere, labelDernierDiplome, labelEmail, labelTelephone, labelAdresse, labelMotivation;
    private int selectedDossierId;

    public void setDossier(DossierInscription dossier) {
        labelNomPrenom.setText(dossier.getNom() + " " + dossier.getPrenom());
        labelFiliere.setText(dossier.getFiliere());
        labelDernierDiplome.setText(dossier.getDernierDiplome());
        labelEmail.setText(dossier.getEmail());
        labelTelephone.setText(dossier.getTelephone());
        labelMotivation.setText(dossier.getMotivation());
    }


    }


