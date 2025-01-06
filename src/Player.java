public class Player {
    

    public String name;
    public int level; 
    public int coins; 


    /**
     * Constructeur de la classe Player.
     * 
     * @param name  Nom du joueur.
     * @param level Niveau du joueur.
     * @param coins Nombre de pièces du joueur.
     */
    public Player(String name, int level, int coins) {
        this.name = name;
        this.level = level;
        this.coins = coins;
    }

    
    /**
     * methode abstract à implementer dans aiplayer et human player pour la définition des directions.
     * @return
     */
    public abstract Direction getDirection(); 
    
    /**
     * Getter pour l'attribut name.
     * 
     * @return Le nom du joueur.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour l'attribut name.
     * Permet de modifier le nom du joueur.
     * 
     * @param name Le nouveau nom du joueur.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour l'attribut level.
     * 
     * @return Le niveau du joueur.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter pour l'attribut level.
     * Permet de modifier le niveau du joueur.
     * 
     * @param level Le nouveau niveau du joueur.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Getter pour l'attribut coins.
     * 
     * @return Le nombre de pièces du joueur.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Setter pour l'attribut coins.
     * Permet de modifier le nombre de pièces du joueur.
     * 
     * @param coins Le nouveau nombre de pièces du joueur.
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
}
