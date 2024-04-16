package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DossierInscription;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateDossInscription {
    @FXML
    private DatePicker UpDate;

    @FXML
    private TextField UpHeure;

    @FXML
    private TextField UpFilliere;

    @FXML
    private TextArea UpMotivation;

    @FXML
    private Button UpDossier;

    Connection maConnexion = bdd.getConnection();

    public UpdateDossInscription() throws Exception {
    }

    public void initialize(){
        ObservableList<DossierInscription> dossierSelectedData = DossierInscription.getDossierSelectedData();
        if(!dossierSelectedData.isEmpty()){
            DossierInscription dossierInscription = dossierSelectedData.get(0);
            UpDate.setValue(Date.valueOf(String.valueOf(dossierInscription.getDate())).toLocalDate());
            UpHeure.setText(dossierInscription.getHeure());
            UpFilliere.setText(dossierInscription.getFiliere());
            UpMotivation.setText(dossierInscription.getMotivation());
        }
    }


    @FXML
    void UpDossInscription(ActionEvent event) throws Exception{
        int selectedDossierId = DossierInscription.getSelectedDossierId();
        try{
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH':'mm");
            java.util.Date heureDate =  inputFormat.parse(UpHeure.getText());
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            String heureFormatted = outputFormat.format(heureDate);
            PreparedStatement upDossier = maConnexion.prepareStatement("UPDATE dossierinscription SET date = ?, heure = ?, filiere = ?, motivation = ? WHERE id = ?");
            upDossier.setDate(1, Date.valueOf(UpDate.getValue()));
            upDossier.setString(2, heureFormatted);
            upDossier.setString(3, UpFilliere.getText());
            upDossier.setString(4, UpMotivation.getText());
            upDossier.setInt(5, selectedDossierId);
            upDossier.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modification !");
            alert.setContentText("Le dossier d'inscription  a été modifié avec succés ! Actualisé pour voir les changements !");
            alert.showAndWait();

            HelloApplication.sceneConnexion("DossierInscriptionList");

        }catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setContentText("Veuillez saisir l'heure au format 'HH:mm', par exemple '10:00'.");
            alert.showAndWait();
        }






    }
}
