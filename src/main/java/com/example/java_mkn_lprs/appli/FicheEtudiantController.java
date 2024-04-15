package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
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
import java.util.ArrayList;

public class FicheEtudiantController {
    @FXML
    private TableView<FicheEtudiant> FicheEtudiantList;

    @FXML
    private TableColumn<FicheEtudiant, Integer> id_fiche;

    @FXML
    private TableColumn<FicheEtudiant, String> nom;

    @FXML
    private TableColumn<FicheEtudiant, String> prenom;

    @FXML
    private TableColumn<FicheEtudiant,  String> email;

    @FXML
    private TableColumn<FicheEtudiant, String> telephone;

    @FXML
    private TableColumn<FicheEtudiant, String> adresse;

    @FXML
    private TableColumn<FicheEtudiant, String> dernier_diplome;

    @FXML
    private Button Refresh;

    @FXML
    private Button Ajouter;

    @FXML
    private Button Modifer;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Logout;

    public ArrayList<FicheEtudiant> data  = new ArrayList<FicheEtudiant>();

    Connection maConnexion = bdd.getConnection();

    public FicheEtudiantController() throws Exception {
    }


    public void initialize()throws Exception{
        ObservableList<FicheEtudiant> ficheData = FXCollections.observableArrayList();
        Utilisateur unUser  = new Utilisateur();
        PreparedStatement psFiche = maConnexion.prepareStatement("SELECT * FROM ficheetudiant WHERE ref_secretaire = ?" );
        psFiche.setInt(1, Utilisateur.getUtilisateurConnecteId());
        ResultSet rsFiche = psFiche.executeQuery();
        while(rsFiche.next()) {
            data.add(new FicheEtudiant(rsFiche.getInt("id"), rsFiche.getString("nom"), rsFiche.getString("prenom"), rsFiche.getString("dernier_diplome"),
                    rsFiche.getString("email"), rsFiche.getString("telephone"), rsFiche.getString("adresse")));
        }
        ficheData.addAll(data);

        id_fiche.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, Integer>("id_fiche"));
        nom.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("email"));
        telephone.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("telephone"));
        adresse.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("adresse"));
        dernier_diplome.setCellValueFactory(new PropertyValueFactory<FicheEtudiant, String>("dernier_diplome"));

        FicheEtudiantList.setItems(ficheData);
    }
    @FXML
    void resfreshList(ActionEvent event) throws Exception{
        ObservableList<FicheEtudiant> ficheData = FXCollections.observableArrayList();

        data.clear();

        PreparedStatement ps = maConnexion.prepareStatement("SELECT * FROM ficheetudiant WHERE ref_secretaire = ?");
        ps.setInt(1, Utilisateur.getUtilisateurConnecteId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            data.add(new FicheEtudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
                    rs.getString("telephone"), rs.getString("adresse"), rs.getString("dernier_diplome")));
        }
        ficheData.addAll(data);

        FicheEtudiantList.setItems(ficheData);
    }

    @FXML
    void AddFichEtud(ActionEvent event) {
        HelloApplication.sceneConnexion("addFicheEtudiant");

    }
    @FXML
    void UpdateFichEtud(ActionEvent event) {
        ObservableList<FicheEtudiant> ficheselected;
        ficheselected = FicheEtudiantList.getSelectionModel().getSelectedItems();
        if(!ficheselected.isEmpty()){
            FicheEtudiant.setFicheSelectedData(ficheselected);
            int selectedFicheId = ficheselected.get(0).getId_fiche();
            FicheEtudiant.setSelectedFicheId(selectedFicheId);
            HelloApplication.sceneConnexion("updateFicheEtudiant");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("Aucune fiche étudiant sélectionnée !");
            alert.showAndWait();
        }


    }

    @FXML
    void DeleteFichEtud(ActionEvent event) throws Exception{
        ObservableList<FicheEtudiant> ficheselected;
        ficheselected = FicheEtudiantList.getSelectionModel().getSelectedItems();
        if(ficheselected.size()>0){
            PreparedStatement deleteListe = maConnexion.prepareStatement("DELETE FROM ficheetudiant WHERE id = ?");
            deleteListe.setInt(1, ficheselected.get(0).getId_fiche());
            deleteListe.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppresion !");
            alert.setContentText("La fiche étudiant de"+ ficheselected.get(0).getNom() +" a été supprimée avec succés ! Actualiser pour voir les changements !");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("Aucune fiche étudiant séléctionnée !");
            alert.showAndWait();
        }
    }

    @FXML
    void AddDossierInscription(ActionEvent event) {
        ObservableList<FicheEtudiant> ficheselected;
        ficheselected = FicheEtudiantList.getSelectionModel().getSelectedItems();
        if(!ficheselected.isEmpty()){
            int selectedFicheId = ficheselected.get(0).getId_fiche();
            FicheEtudiant.setSelectedFicheId(selectedFicheId);
            HelloApplication.sceneConnexion("addDossInscription");
        }



    }
    @FXML
    void Retour(ActionEvent event) {
        HelloApplication.sceneConnexion("Secretaire_accueil");
    }


    @FXML
    void Logout(ActionEvent event) {
        HelloApplication.sceneConnexion("hello-view");
    }






}

