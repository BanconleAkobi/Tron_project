import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
    private Map<Player, Integer> scores;

    public Scoreboard() {
        scores = new HashMap<>();
    }

    public void addScore(Player player, int score) {
        scores.put(player, scores.getOrDefault(player, 0) + score);
    }

    public void displayScores() {
        System.out.println("player rankings :");
        scores.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(e -> System.out.println(e.getKey().getName() + ": " + e.getValue() + " points"));
    }
}
