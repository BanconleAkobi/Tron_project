import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scoreboard {
    private Map<String, Integer> scores = new HashMap<>();

    public void addScore(String playerName, int score) {
        scores.put(playerName, score);
    }

    public List<Map.Entry<String, Integer>> getTopScores() {
        return scores.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
    }
}
