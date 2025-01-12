package Game;


import javafx.scene.paint.Color;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, int startX, int startY, Color color) {
        super(name, startX, startY, color);
    }

    @Override
    public void move() {
        int speed = 10;
        switch (direction) {
            case UP -> y -= speed;
            case DOWN -> y += speed;
            case LEFT -> x -= speed;
            case RIGHT -> x += speed;
        }
    }
}