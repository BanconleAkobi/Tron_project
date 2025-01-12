package Game;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Shop {
    public void displayShop(Player player) {
        Stage shopStage = new Stage();
        shopStage.setTitle("Shop");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label title = new Label("Shop");
        title.setStyle("-fx-font-size: 20px;");
        Button speedBoostButton = new Button("Speed Boost (10 coins)");
        speedBoostButton.setOnAction(e -> {
            if (purchaseItem(player, "Boost de vitesse", 10)) {
                player.increaseMoveSpeed(); // Ajout de la méthode pour éviter l'erreur
            }
            shopStage.close();
        });
        layout.getChildren().addAll(title, speedBoostButton);

        Scene scene = new Scene(layout, 300, 200);
        shopStage.setScene(scene);
        shopStage.show();
    }

    public boolean purchaseItem(Player player, String itemName, int price) {
        if (player.getCoins() >= price) {
            player.decreaseCoins(price);
            System.out.println(player.getName() + " purchased " + itemName + "!");
            return true;
        } else {
            System.out.println("Insufficient coins!");
            return false;
        }
    }
}