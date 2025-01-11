package com.example.test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 300);

        // Définir une Timeline pour exécuter une action toutes les 2 secondes
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> {
                    // Action à effectuer
                    System.out.println("Action exécutée à : " + System.currentTimeMillis());
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Répète indéfiniment
        timeline.play(); // Démarre la Timeline

        primaryStage.setScene(scene);
        primaryStage.setTitle("Mise à jour périodique");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
