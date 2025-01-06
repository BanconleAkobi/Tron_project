public class Tron extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(10);
        Button playButton = new Button("Jouer");
        playButton.setOnAction(e -> {
            new GameWindow().show();
        });
        layout.getChildren().add(playButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
