package com.example.java_mkn_lprs.appli;
import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProfesseurController {

    @FXML
    private Button id_button_prof_menu;

    @FXML
    private Button id_button_prof_menu1;

    @FXML
    private Button id_button_fichefourniture;

    @FXML
    void ask_fourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("demande_fourniture");
    }

    @FXML
    void show_fourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("show_demande");
    }

    @FXML
    void create_fichefourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("Create_fichefourniture");
    }
}
