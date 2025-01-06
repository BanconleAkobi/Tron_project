public class Asset {
    public String name; 
    public int price;
    
    /**
     * Constructeur de la classe Asset.
     * 
     * @param name  Nom de l'actif (asset).
     * @param price Prix de l'actif (asset).
     */
    public Asset(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Getter pour l'attribut name.
     * 
     * @return Le nom de l'actif.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour l'attribut name.
     * Permet de modifier le nom de l'actif.
     * 
     * @param name Le nouveau nom de l'actif.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour l'attribut price.
     * 
     * @return Le prix de l'actif.
     */
    public int getPrice() {
        return price;
    }

    /**
     * 
     * @param price Le nouveau prix de l'actif.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
