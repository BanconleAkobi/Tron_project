public class Moto {
    public double speed; 
    public float image; 

    /**
     * Constructeur de la classe Moto.
     * 
     * @param speed Vitesse de la moto.
     * @param image Représentation de l'image associée à la moto.
     */
    public Moto(double speed, float image) {
        this.speed = speed;
        this.image = image;
    }

    /**
     * Getter pour l'attribut speed.
     * 
     * @return La vitesse de la moto.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Setter pour l'attribut speed.
     * Permet de modifier la vitesse de la moto.
     * 
     * @param speed La nouvelle vitesse de la moto.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Getter pour l'attribut image.
     * 
     * @return La représentation de l'image associée à la moto.
     */
    public float getImage() {
        return image;
    }

    /**
     * Setter pour l'attribut image.
     * Permet de modifier la représentation de l'image associée à la moto.
     * 
     * @param image La nouvelle représentation de l'image.
     */
    public void setImage(float image) {
        this.image = image;
    }
}
