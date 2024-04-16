package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.DossierInscription;
import com.example.java_mkn_lprs.modele.FicheEtudiant;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class DossierInscriptionController {
    @FXML
    private TableView<DossierInscription> DossierInscripList;

    @FXML
    private TableColumn<DossierInscription, Integer> id_dossier;

    @FXML
    private TableColumn<DossierInscription, Date> date;

    @FXML
    private TableColumn<DossierInscription, String> heure;

    @FXML
    private TableColumn<DossierInscription, String> filiere;

    @FXML
    private TableColumn<DossierInscription, String> motivation;


    @FXML
    private Button Modifer;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Logout;

    @FXML
    private Button Refresh;

    Connection maConnexion = bdd.getConnection();
    public ArrayList<DossierInscription> data  = new ArrayList<DossierInscription>();

    public DossierInscriptionController() throws Exception {
    }


    public void initialize() throws Exception{
        ObservableList<DossierInscription> dossierData = FXCollections.observableArrayList();
        PreparedStatement psDossier = maConnexion.prepareStatement
                ("SELECT * FROM dossierinscription  WHERE ref_secretaire = ?");
        psDossier.setInt(1, Utilisateur.getUtilisateurConnecteId());
        ResultSet rsDossier = psDossier.executeQuery();
        while (rsDossier.next()){
            data.add(new DossierInscription(rsDossier.getDate("date"), rsDossier.getString("heure"),
                    rsDossier.getString("filiere"), rsDossier.getString("motivation"),rsDossier.getInt("id")));
        }
        dossierData.addAll(data);

        id_dossier.setCellValueFactory(new PropertyValueFactory<DossierInscription, Integer>("id"));
        date.setCellValueFactory(new  PropertyValueFactory<DossierInscription, Date>("date"));
        heure.setCellValueFactory(new PropertyValueFactory<DossierInscription, String>("heure"));
        filiere.setCellValueFactory(new PropertyValueFactory<DossierInscription, String>("filiere"));
        motivation.setCellValueFactory(new PropertyValueFactory<DossierInscription, String>("motivation"));

        DossierInscripList.setItems(dossierData);

    }
    @FXML
    void resfreshList(ActionEvent event) throws Exception{
        ObservableList<DossierInscription> dossierData = FXCollections.observableArrayList();
        data.clear();
        PreparedStatement ps = maConnexion.prepareStatement("SELECT * FROM dossierinscription WHERE ref_secretaire = ?");
        ps.setInt(1, Utilisateur.getUtilisateurConnecteId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            data.add(new DossierInscription(rs.getDate("date"), rs.getString("heure"),
                    rs.getString("filiere"), rs.getString("motivation"),rs.getInt("id")));
        }
        dossierData.addAll(data);
        DossierInscripList.setItems(dossierData);
    }
    @FXML
    void UpdateDossInscrip(ActionEvent event) {
        ObservableList<DossierInscription> dossierselected;
        dossierselected = DossierInscripList.getSelectionModel().getSelectedItems();
        if(!dossierselected.isEmpty()){
            DossierInscription.setDossierSelectedData(dossierselected);
            int selectedDossierId = dossierselected.get(0).getId();
            DossierInscription.setSelectedDossierId(selectedDossierId);
            HelloApplication.sceneConnexion("updateDossInscrip");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("Aucun dossier d'inscription séléctionné !");
            alert.showAndWait();
        }



    }

    @FXML
    void DeleteDossInscrip(ActionEvent event) throws Exception{
        ObservableList<DossierInscription> dossierselected;
        dossierselected = DossierInscripList.getSelectionModel().getSelectedItems();
        if(dossierselected.size()>0){
            PreparedStatement deleteDossier = maConnexion.prepareStatement("DELETE FROM dossierinscription WHERE id = ?");
            deleteDossier.setInt(1, dossierselected.get(0).getId());
            deleteDossier.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppresion !");
            alert.setContentText("Le dossier d'inscription a été supprimé avec succés ! Actualiser pour voir les changements !");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("Aucun dossier d'inscription séléctionné !");
            alert.showAndWait();
        }
    }

    @FXML
    void Logout(ActionEvent event) {
        HelloApplication.sceneConnexion("hello-view");
    }

    @FXML
    void Retour(ActionEvent event) {
        HelloApplication.sceneConnexion("Secretaire_accueil");
    }

}
