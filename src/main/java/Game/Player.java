package Game;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String name;
    protected int x, y;
    protected Color color;
    protected Direction direction;
    protected List<Rectangle> trail;
    protected boolean alive;
    protected int coins;
    protected int moveSpeed;

    public Player(String name, int startX, int startY, Color color) {
        this.name = name;
        this.x = startX;
        this.y = startY;
        this.color = color;
        this.direction = Direction.RIGHT;
        this.alive = true;
        this.trail = new ArrayList<>();
        this.coins = 0;
        this.moveSpeed = 10; // Vitesse initiale
    }

    public abstract void move();

    public void leaveTrail(Pane root) {
        Rectangle rect = new Rectangle(x, y, 10, 10);
        rect.setFill(Color.web(color.toString(), 0.8));
        rect.setArcWidth(5);
        rect.setArcHeight(5);
        trail.add(rect);
        root.getChildren().add(rect);
    }

    public boolean hasCollided(int width, int height, List<Player> players) {
        if (x < 0 || x >= width || y < 0 || y >= height) return true;
        for (Player p : players) {
            if (p != this && p.trail.stream().anyMatch(part -> part.getX() == x && part.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void resetPosition() {
        this.x = (int) (Math.random() * 400 + 100);
        this.y = (int) (Math.random() * 200 + 100);
        this.trail.clear();
    }

    public void draw(Pane root) {
        Rectangle rect = new Rectangle(x, y, 10, 10);
        rect.setFill(color);
        root.getChildren().add(rect);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void decreaseCoins(int amount) {
        if (coins >= amount) {
            coins -= amount;
        }
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void increaseMoveSpeed() {
        this.moveSpeed += 2; // Augmente la vitesse de déplacement
    }
}
