package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GSController {

    public Button id_button_GS;

    @FXML
    void show_fournituregs(ActionEvent event) {
        HelloApplication.sceneConnexion("show_demande_gs");
    }

    @FXML
    public void create_fichefourniture(ActionEvent event) {
        HelloApplication.sceneConnexion("Create_fichefourniture");
    }
}
