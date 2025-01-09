public class HumanPlayer extends Player {

    public HumanPlayer(String name, int level, int coins) {
        super(name, level, coins);
    }

    @Override
    public Direction getDirection() {
        // Ici, JavaFX permettra de récupérer les touches du clavier
        return Direction.UP;  // Placeholder
    }
}
