package com.example.test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    private static final int GRID_SIZE = 20;
    private static final int CELL_SIZE = 30;
    private Rectangle[][] grid = new Rectangle[GRID_SIZE][GRID_SIZE];
    private int playerX = 0;
    private int playerY = 0;
    private char direction = 'S';

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Initialiser la grille
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.GRAY);
                cell.setStroke(Color.BLACK);
                grid[row][col] = cell;
                gridPane.add(cell, col, row);
            }
        }

        // Initialiser la position du joueur
        grid[playerY][playerX].setFill(Color.WHITE);

        Scene scene = new Scene(gridPane, (GRID_SIZE * CELL_SIZE) + 20, (GRID_SIZE * CELL_SIZE) + 20);

        // Recup les chgmnt de direction
        scene.setOnKeyPressed(event -> setDirection(event));

        // Timeline pour déplacer le joueur
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.25), event -> {
                    movePlayer(direction);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Répète indéfiniment
        timeline.play(); // Démarre la Timeline

        primaryStage.setTitle("Tron");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setDirection(KeyEvent event) {
        switch (event.getCode()) {
            case Z:
                direction = 'Z';
                break;
            case S:
                direction = 'S';
                break;
            case Q:
                direction = 'Q';
                break;
            case D:
                direction = 'D';
                break;
            default:
                break;
        }
    }

    private void movePlayer(char direction) {
        switch (direction) {
            case 'Z':
                if (playerY > 0) {
                    playerY--;
                } else {
                    System.out.println("Game over");
                }
                break;
            case 'S':
                if (playerY < GRID_SIZE - 1) {
                    playerY++;
                } else {
                    System.out.println("Game over");
                }
                break;
            case 'Q':
                if (playerX > 0) {
                    playerX--;
                } else {
                    System.out.println("Game over");
                }
                break;
            case 'D':
                if (playerX < GRID_SIZE - 1) {
                    playerX++;
                    System.out.println(playerX);
                } else {
                    System.out.println("Game over");
                }
                break;
            default:
                break;
        }

        // Mettre à jour la nouvelle position du joueur
        grid[playerY][playerX].setFill(Color.WHITE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
