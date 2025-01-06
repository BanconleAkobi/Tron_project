public class Inventory {

    public String name; 
    public int price;

    /**
     * Constructeur de la classe Inventory.
     * 
     * @param name  Nom de l'inventaire.
     * @param price Prix de l'inventaire.
     */
    public Inventory(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter pour l'attribut name.
     * 
     * @return Le nom de l'inventaire.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour l'attribut name.
     * Permet de modifier le nom de l'inventaire.
     * 
     * @param name Le nouveau nom de l'inventaire.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour l'attribut price.
     * 
     * @return Le prix de l'inventaire.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter pour l'attribut price.
     * Permet de modifier le prix de l'inventaire.
     * 
     * @param price Le nouveau prix de l'inventaire.
     */
    public void setPrice(int price) {
        this.price = price;
    }


}
