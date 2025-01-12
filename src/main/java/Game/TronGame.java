package Game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;


public class TronGame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Pane root;
    private Text scoreText;
    private List<Player> players;
    private HashMap<KeyCode, Direction> controls;
    private boolean gameRunning = false;
    private AnimationTimer gameLoop;

    public void start(Stage primaryStage) {
        players = new ArrayList<>();
        controls = new HashMap<>();
        setupUI(primaryStage);
        setupPlayers();
        setupControls();
    }

    private void setupUI(Stage primaryStage) {
        root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tron Game");

        scoreText = new Text("Scores : ");
        scoreText.setFill(Color.WHITE);
        scoreText.setStyle("-fx-font-size: 16px;");
        scoreText.setX(10);
        scoreText.setY(20);
        root.getChildren().add(scoreText);

        Button openShopButton = new Button("Ouvrir la Boutique");
        openShopButton.setLayoutX(WIDTH / 2.0 - 60);
        openShopButton.setLayoutY(HEIGHT / 2.0 + 80);
        openShopButton.setStyle("-fx-font-size: 16px;");
        root.getChildren().add(openShopButton);

        openShopButton.setOnAction(e -> {
            Shop shop = new Shop();
            shop.displayShop(players.get(0));
        });

        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #0f0f0f, #4f4f4f);");

        Text titleText = new Text("Tron Light Cycles");
        titleText.setFill(Color.WHITE);
        titleText.setStyle("-fx-font-size: 36px; -fx-font-weight: bold;");
        titleText.setX(WIDTH / 2.0 - 140);
        titleText.setY(HEIGHT / 4.0);
        root.getChildren().add(titleText);

        Button startButton = new Button("Démarrer la partie");
        startButton.setLayoutX(WIDTH / 2.0 - 60);
        startButton.setLayoutY(HEIGHT / 2.0 - 20);
        startButton.setStyle("-fx-font-size: 16px;");
        root.getChildren().add(startButton);

        Button quitButton = new Button("Quitter");
        quitButton.setLayoutX(WIDTH / 2.0 - 60);
        quitButton.setLayoutY(HEIGHT / 2.0 + 40);
        quitButton.setStyle("-fx-font-size: 16px;");
        root.getChildren().add(quitButton);

        startButton.setOnAction(e -> {
            root.getChildren().remove(titleText);
            root.getChildren().remove(startButton);
            root.getChildren().remove(quitButton);
            startGame();
        });
        quitButton.setOnAction(e -> System.exit(0));

        primaryStage.show();
    }

    private void updateScores() {
        StringBuilder scores = new StringBuilder("Scores : ");
        for (Player player : players) {
            scores.append(player.getName()).append(": ").append(player.getCoins()).append(" | ");
        }
        scoreText.setText(scores.toString());  // Met à jour l'affichage des scores dans l'interface
    }



    private void stopGame() {
        gameRunning = false;  // Arrête la boucle du jeu
        gameLoop.stop();  // Stoppe l'animation principale

        // Trouve le nom du gagnant
        String winner = players.stream().filter(Player::isAlive).map(Player::getName).findFirst().orElse("No one");

        // Affiche un message avec le résultat
        Text resultText = new Text(winner + " wins! Appuyez sur ENTER pour recommencer.");
        resultText.setFill(Color.YELLOW);
        resultText.setStyle("-fx-font-size: 22px;");
        resultText.setX(WIDTH / 2 - 140);
        resultText.setY(HEIGHT / 2);
        root.getChildren().add(resultText);

        // Permet de redémarrer le jeu lorsque l'utilisateur appuie sur ENTER
        root.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                root.getChildren().clear();  // Réinitialise l'interface
                setupUI((Stage) root.getScene().getWindow());  // Recharge l'UI principale
            }
        });
    }


    public void startGame() {
        gameRunning = true; // Activation du jeu
        scoreText.setText("Scores : ");  // Réinitialisation des scores
        players.forEach(player -> {
            player.resetPosition();
            player.draw(root);
        });

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                players.forEach(player -> {
                    if (player.isAlive()) {
                        player.move();
                        updateScores();
                        player.leaveTrail(root);
                        if (player.hasCollided(WIDTH, HEIGHT, players)) {
                            player.setAlive(false);
                            showExplosion(player.x, player.y);
                        }
                    }
                });
                if (players.stream().filter(Player::isAlive).count() <= 1) {
                    stopGame();
                }
            }
        };
        gameLoop.start();
    }

    private void setupPlayers() {
        players.add(new HumanPlayer("Player 1", 100, HEIGHT / 2, Color.RED));
        players.add(new HumanPlayer("Player 2", WIDTH - 100, HEIGHT / 2, Color.BLUE));
        players.add(new AIPlayer("Bot 1", WIDTH / 2, HEIGHT / 2 - 100, Color.GREEN));
    }

    private void setupControls() {
        controls.put(KeyCode.UP, Direction.UP);
        controls.put(KeyCode.DOWN, Direction.DOWN);
        controls.put(KeyCode.LEFT, Direction.LEFT);
        controls.put(KeyCode.RIGHT, Direction.RIGHT);
        controls.put(KeyCode.W, Direction.UP);
        controls.put(KeyCode.S, Direction.DOWN);
        controls.put(KeyCode.A, Direction.LEFT);
        controls.put(KeyCode.D, Direction.RIGHT);

        root.getScene().setOnKeyPressed(e -> {
            if (controls.containsKey(e.getCode()) && gameRunning) {
                players.get(0).setDirection(controls.get(e.getCode()));
            }
        });
    }

    private void showExplosion(double x, double y) {
        for (int i = 0; i < 15; i++) {
            Circle particle = new Circle(x + (Math.random() * 20 - 10), y + (Math.random() * 20 - 10), 5, Color.RED);
            root.getChildren().add(particle);
            FadeTransition fade = new FadeTransition(Duration.seconds(0.7), particle);
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished(e -> root.getChildren().remove(particle));
            fade.play();
        }
    }
}
