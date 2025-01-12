package Game;


import javafx.scene.paint.Color;
public class AIPlayer extends Player {
    public AIPlayer(String name, int startX, int startY, Color color) {
        super(name, startX, startY, color);
    }

    @Override
    public void move() {
        if (x < 50) {
            direction = Direction.RIGHT;
        } else if (x > 750) {
            direction = Direction.LEFT;
        } else if (y < 50) {
            direction = Direction.DOWN;
        } else if (y > 550) {
            direction = Direction.UP;
        } else {
            int randomChoice = (int) (Math.random() * 4);
            direction = switch (randomChoice) {
                case 0 -> Direction.UP;
                case 1 -> Direction.DOWN;
                case 2 -> Direction.LEFT;
                case 3 -> Direction.RIGHT;
                default -> direction;
            };
        }
        int speed = 10;
        switch (direction) {
            case UP -> y -= speed;
            case DOWN -> y += speed;
            case LEFT -> x -= speed;
            case RIGHT -> x += speed;
        }
    }
}