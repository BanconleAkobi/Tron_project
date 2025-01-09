import java.util.ArrayList;
import java.util.List;

public class Tron {
    private List<Player> players;
    private Scoreboard scoreboard;

    public Tron() {
        this.players = new ArrayList<>();
        this.scoreboard = new Scoreboard();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        System.out.println("Game started !");
        for (Player player : players) {
            System.out.println(player.getName() + " is ready");
        }
    }

    public void simulateGame() {
        for (Player player : players) {
            int score = (int) (Math.random() * 1000);  // Simulation du score
            scoreboard.addScore(player, score);
        }
        endGame();
    }

    public void endGame() {
        System.out.println("End of the game !");
        scoreboard.displayScores();
    }

    public void showShop(Player player) {
        System.out.println("Welcom in the  shop !");
        Moto moto1 = new Moto("Red moto ", 200, 10.0, "C:\\Users\\admin\\Documents\\FISA 3 INFO S5\\JAVA\\Tron_project\\Assets\\img.png");
        Trail trail1 = new Trail("Flamme Rouge", 100, "Red");

        player.buyAsset(moto1);
        player.buyAsset(trail1);
    }
}
