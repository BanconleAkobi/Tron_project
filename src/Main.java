public class Main {
    public static void main(String[] args) {
        Tron game = new Tron();
        HumanPlayer humanPlayer = new HumanPlayer("Enzo", 1, 500);
        AIPlayer aiPlayer = new AIPlayer("Bot Alpha", 3, 300);

        game.addPlayer(humanPlayer);
        game.addPlayer(aiPlayer);

        game.startGame();
        game.showShop(humanPlayer);  // Achat d'objets
        game.simulateGame();  // Simulation d'une partie
    }
}
