package com.example.java_mkn_lprs.appli;

import BDD.bdd;
import com.example.java_mkn_lprs.HelloApplication;
import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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


public class AdminController {
    @FXML
    private TableView<Utilisateur> UserList;
    @FXML
    private TableColumn<Utilisateur, Integer> id_user;

    @FXML
    private TableColumn<Utilisateur, String> nom;

    @FXML
    private TableColumn<Utilisateur, String> prenom;

    @FXML
    private TableColumn<Utilisateur, String> email;

    @FXML
    private TableColumn<Utilisateur, String> profil;

    public ArrayList<Utilisateur> data  = new ArrayList<Utilisateur>();

    Connection maConnexion = bdd.getConnection();


    @FXML
    private Button Ajouter;

    @FXML
    private Button Modifer;

    @FXML
    private Button Supprimer;

    @FXML
    private Button Refresh;

    @FXML
    private Button Logout;

    public AdminController() throws Exception {
    }

    public void initialize()throws Exception{
        ObservableList<Utilisateur> userData = FXCollections.observableArrayList();
        PreparedStatement psUser = maConnexion.prepareStatement("SELECT * FROM users  ");
        ResultSet rs = psUser.executeQuery();
        while(rs.next()) {
            data.add(new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"), rs.getString("profil")));
        }
        System.out.println(data.get(1).getId());
        userData.addAll(data);
        id_user.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        profil.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("profil"));

        UserList.setItems(userData);

    }


    @FXML
    void AddUser(ActionEvent event) {
        HelloApplication.sceneConnexion("addUser");
    }

    @FXML
    void DeleteUser(ActionEvent event) throws Exception{
        ObservableList<Utilisateur> userselected;
        userselected = UserList.getSelectionModel().getSelectedItems();
        if(userselected.size()>0){
            PreparedStatement deleteListe = maConnexion.prepareStatement("DELETE FROM users WHERE id = ?");
            deleteListe.setInt(1, userselected.get(0).getId());
            deleteListe.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppresion !");
            alert.setContentText("L'utilisateur "+ userselected.get(0).getNom() +" a été supprimé avec succés ! Actualiser pour voir les changements !");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR");
            alert.setContentText("Aucun utilisateur séléctionné !");
            alert.showAndWait();
        }

    }

    @FXML
    void UpdateUser(ActionEvent event) {
        ObservableList<Utilisateur> userselected;
        userselected = UserList.getSelectionModel().getSelectedItems();
        HelloApplication.setUserSelectedData(userselected);
        int selectedUserId = userselected.get(0).getId();
        HelloApplication.setSelectedUserId(selectedUserId);
        HelloApplication.setUserSelectedData(userselected);
        HelloApplication.sceneConnexion("updateUser");

    }
    @FXML
    void resfreshList(ActionEvent event) throws Exception{
        ObservableList<Utilisateur> userData = FXCollections.observableArrayList();

        data.clear();

        PreparedStatement ps = maConnexion.prepareStatement("SELECT * FROM users ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            data.add(new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"),rs.getString("profil")));
        }
        userData.addAll(data);

        UserList.setItems(userData);
    }

    @FXML
    void Logout(ActionEvent event) {
        HelloApplication.sceneConnexion("hello-view");
    }


}
