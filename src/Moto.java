public class Moto extends Asset {
    private double speed;  // Vitesse de la moto
    private String imagePath;  // Chemin de l'image

    public Moto(String name, int price, double speed, String imagePath) {
        super(name, price);
        this.speed = speed;
        this.imagePath = imagePath;
    }

    public double getSpeed() {
        return speed;
    }

    public String getImagePath() {
        return imagePath;
    }
}
