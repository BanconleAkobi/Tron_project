public abstract class Player {
    protected String name;
    protected int level;
    protected int coins;  // Nombre de pièces du joueur
    protected Inventory inventory;  // Inventaire du joueur

    public Player(String name, int level, int coins) {
        this.name = name;
        this.level = level;
        this.coins = coins;
        this.inventory = new Inventory(coins);
    }

    public abstract Direction getDirection();

    // Méthode pour acheter un objet dans le shop
    public boolean buyAsset(Asset asset) {
        return inventory.addAsset(asset);
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
        this.inventory.setCoins(coins);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
