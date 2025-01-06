import java.awt.Color;

public class Trail {
    public Color color;

     /**
     * Constructeur de la classe Trail.
     * 
     * @param color Couleur de la trace (trail).
     */
    public Trail(Color color) {
        this.color = color;
    }

    /**
     * Getter pour l'attribut color.
     * 
     * @return La couleur de la trace (trail).
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter pour l'attribut color.
     * Permet de modifier la couleur de la trace (trail).
     * 
     * @param color La nouvelle couleur de la trace.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
