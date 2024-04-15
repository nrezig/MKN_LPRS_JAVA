package com.example.java_mkn_lprs.appli;

import com.example.java_mkn_lprs.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminController {
    @FXML
    private Button Users;

    @FXML
    private Button Salles;

    @FXML
    void RedirectToSalleList(ActionEvent event) {

    }

    @FXML
    void RedirectToUserList(ActionEvent event) {
        HelloApplication.sceneConnexion("UserList");

    }

}
