package com.example.java_mkn_lprs.appli;

// Import des classes nécessaires
import BDD.bdd;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.java_mkn_lprs.modele.DemandeFourniture;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Définition de la classe
public class AfficherDemandeGSController {

    // Déclaration des éléments de l'interface utilisateur JavaFX avec l'annotation @FXML
    @FXML
    private TableColumn<DemandeFourniture, String> fourniture_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> prof_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> quantite_colonne;
    @FXML
    private TableColumn<DemandeFourniture, String> raison_colonne;
    @FXML
    private Button id_valider;
    @FXML
    private Button id_refuser;
    private DemandeFourniture selectitems; // Sélection d'un élément dans la TableView
    @FXML
    private TableView<DemandeFourniture> DemandeFourniture; // TableView pour afficher les demandes

    // Méthode d'initialisation appelée lorsque le contrôleur est chargé
    @FXML
    private void initialize() throws Exception {
        // Configuration des cellules des colonnes de la TableView
        prof_colonne.setCellValueFactory(new PropertyValueFactory<>("id"));
        raison_colonne.setCellValueFactory(new PropertyValueFactory<>("raison"));
        quantite_colonne.setCellValueFactory(new PropertyValueFactory<>("quantite_demande"));
        fourniture_colonne.setCellValueFactory(new PropertyValueFactory<>("fourniture_demande"));

        // Affichage des demandes dans la TableView
        afficherDemandes();
    }

    // Méthode pour afficher les demandes dans la TableView
    private void afficherDemandes() throws Exception {
        // Connexion à la base de données
        Connection maConnexion = bdd.getConnection();

        // Requête SQL pour récupérer les demandes
        String query = "SELECT * FROM demandefourniture";
        PreparedStatement rq = maConnexion.prepareStatement(query);
        ResultSet rs = rq.executeQuery();

        // Parcours des résultats de la requête et ajout des demandes à la TableView
        while (rs.next()) {
            int id_demande = rs.getInt("id");
            String raison = rs.getString("raison");
            String quantite_demande = rs.getString("quantite_demande");
            String fourniture_demande = rs.getString("fourniture_demande");
            boolean valide = rs.getBoolean("valide");
            DemandeFourniture demande = new DemandeFourniture(id_demande, raison, quantite_demande, fourniture_demande, valide);
            DemandeFourniture.getItems().add(demande);
        }
    }

    // Méthode appelée lorsqu'une sélection dans la TableView change
    @FXML
    void changed(MouseEvent event) {
        // Vérification si un élément est sélectionné
        if (DemandeFourniture.getSelectionModel().getSelectedItem()!=null){
            // Activation des boutons de validation et de refus
            id_valider.setDisable(false);
            id_refuser.setDisable(false);
            this.selectitems=DemandeFourniture.getSelectionModel().getSelectedItem();
        }
    }

    // Méthode appelée lorsqu'un bouton de refus est cliqué
    @FXML
    void Refuser(MouseEvent event) throws Exception {
        // Récupération de la demande sélectionnée
        DemandeFourniture demandeSelectionnee = DemandeFourniture.getSelectionModel().getSelectedItem();

        // Mise à jour du champ valide de la demande sélectionnée à false (0)
        if (demandeSelectionnee != null) {
            demandeSelectionnee.setValide(false);
            updateDemande(demandeSelectionnee);
        }

        // Désactivation des boutons de validation et de refus après le traitement
        if (DemandeFourniture.getSelectionModel().getSelectedItem()!=null){
            id_valider.setDisable(true);
            id_refuser.setDisable(true);
            this.selectitems=DemandeFourniture.getSelectionModel().getSelectedItem();
        }
    }

    // Méthode appelée lorsqu'un bouton de validation est cliqué
    @FXML
    void Valider(MouseEvent event) throws Exception {
        // Récupération de la demande sélectionnée
        DemandeFourniture demandeSelectionnee = DemandeFourniture.getSelectionModel().getSelectedItem();

        // Mise à jour du champ valide de la demande sélectionnée à true (1)
        if (demandeSelectionnee != null) {
            demandeSelectionnee.setValide(true);
            updateDemande(demandeSelectionnee);
        }

        // Désactivation des boutons de validation et de refus après le traitement
        if (DemandeFourniture.getSelectionModel().getSelectedItem()!=null){
            id_valider.setDisable(true);
            id_refuser.setDisable(true);
            this.selectitems=DemandeFourniture.getSelectionModel().getSelectedItem();
        }
    }

    // Méthode pour mettre à jour la demande dans la base de données
    private void updateDemande(DemandeFourniture demande) throws Exception {
        // Connexion à la base de données
        Connection maConnexion = bdd.getConnection();

        // Requête SQL pour mettre à jour le champ valide de la demande
        String query = "UPDATE demandefourniture SET valide = ? WHERE id = ?";

        // Préparation de la requête
        PreparedStatement statement = maConnexion.prepareStatement(query);

        // Définition des paramètres de la requête
        statement.setBoolean(1, demande.isValide()); // true pour Valider, false pour Refuser
        statement.setInt(2, demande.getId());

        // Exécution de la requête
        statement.executeUpdate();

        // Fermeture des ressources
        statement.close();
    }
}
