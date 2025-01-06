import java.awt.Image;

public class Moto extends Asset {
    public double speed; 
    public Image image; 

    public Moto(String name, int price, double speed, Image image) {
        super(name, price);
        this.speed = speed;
        this.image = image;
    }
}
