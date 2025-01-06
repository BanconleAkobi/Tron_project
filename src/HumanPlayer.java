public class HumanPlayer extends Player{
    
    private Inventory inventory;

    public HumanPlayer(String name, int level, int coins) {
        super(name, level, coins);
        this.inventory = new Inventory();
    }

    @Override
    public Direction getDirection() {
        // Implémentation via écoute des touches clavier
        return Direction.UP; // Exemple temporaire
    }
}

public class AIPlayer extends Player {
    @Override
    public Direction getDirection() {
        // Implémentation logique IA
        return Direction.DOWN; // Exemple temporaire
    }
}
