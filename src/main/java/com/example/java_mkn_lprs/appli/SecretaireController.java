package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecretaireController {
    @FXML
    private Button FichesEtudiants;

    @FXML
    private Button DossiersIncriptions;

    @FXML
    void RedirectToDoissiersInscipList(ActionEvent event) {
        HelloApplication.sceneConnexion("DossierInscriptionList");


    }

    @FXML
    void RedirectToFichesEtudiantsList(ActionEvent event) {
        HelloApplication.sceneConnexion("FichesEtudiantsList");

    }

}
