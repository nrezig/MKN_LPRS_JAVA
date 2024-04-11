package com.example.java_mkn_lprs;

import com.example.java_mkn_lprs.appli.DossiersDetailController;
import com.example.java_mkn_lprs.modele.DossierInscription;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage maStage;



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



    public static void redirectToViewDossiers() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/java_mkn_lprs/ViewDossiers.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            maStage.setTitle("Dossiers d'Inscription");
            maStage.setScene(scene);
            maStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void redirectToViewDossiersDetail(DossierInscription dossier) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/java_mkn_lprs/prof.ViewDossiersDetail.fxml"));
            Parent root = fxmlLoader.load();
            DossiersDetailController controller = fxmlLoader.getController();

            if (controller != null) {
                controller.setDossier(dossier);
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Détails du dossier d'inscription");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}