package com.example.java_mkn_lprs;

import com.example.java_mkn_lprs.modele.Utilisateur;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage maStage;
    private static ObservableList<Utilisateur> userSelectedData;
    public static void setUserSelectedData(ObservableList<Utilisateur> data) {
        userSelectedData = data;
    }
    public static ObservableList<Utilisateur> getUserSelectedData() {
        return userSelectedData;
    }
    private static int selectedUserId;
    public static int getSelectedUserId() {
        return selectedUserId;
    }

    public static void setSelectedUserId(int userId) {
        selectedUserId = userId;
    }

    @Override
    public void start(Stage stage) throws IOException {
        maStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("MKN_LPRS");
        stage.setScene(scene);
        stage.show();
    }
    public static void sceneConnexion(String fxml) {

        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            maStage.setTitle("MKN_LPRS");
            maStage.setScene(scene);
            maStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void sceneConnexion(String fxml, Object controlleur) {
        maStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            maStage.setTitle("ToDoList-Apps");
            maStage.setScene(scene);
            maStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void newStage(String fxml, Object controller) {
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setTitle("MKN_LPRS");
        window.setScene(scene);
        window.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}