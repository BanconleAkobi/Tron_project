package Game;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TronGame game = new TronGame();
        game.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}