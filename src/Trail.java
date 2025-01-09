public class Trail extends Asset {
    private String color;  // Couleur de la traînée

    public Trail(String name, int price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
