
package Game;


import java.util.HashMap;
import java.util.Map;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Leaderboard {
    private final Map<String, Integer> scores = new HashMap<>();

    public void addScore(String playerName, int score) {
        scores.put(playerName, scores.getOrDefault(playerName, 0) + score);
    }

    public void displayScores(Pane root) {
        Text leaderboardText = new Text();
        leaderboardText.setFill(Color.WHITE);
        leaderboardText.setX(20);
        leaderboardText.setY(60);
        leaderboardText.setText(getFormattedScores());
        root.getChildren().add(leaderboardText);
    }

    private String getFormattedScores() {
        StringBuilder sb = new StringBuilder("--- Leaderboard ---\n");
        scores.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));
        return sb.toString();
    }
}
