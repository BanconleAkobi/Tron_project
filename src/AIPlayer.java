import java.util.HashSet;
import java.util.Set;

public class AIPlayer extends Player {
    private Set<Position> visitedPositions = new HashSet<>();

    public AIPlayer(String name, int level, int coins) {
        super(name, level, coins);
    }

    @Override
    public Direction getDirection() {
        // Implémentation spécifique : évite les murs déjà visités
        return Direction.RIGHT;  // Placeholder simplifié
    }
}
