import java.awt.Color;

public class Trail extends Asset {
    public Color color;

    public Trail(String name, int price, Color color) {
        super(name, price);
        this.color = color;
    }
}
