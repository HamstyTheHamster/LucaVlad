package Game;

/**
 * Class that represents a bullet.
 */
public class Bullet extends Entity {
    
    /**
     * Constructor for making a bullet, scalable to the map. 
     * @param startx
     *      x start, usually player
     * @param starty
     *      y start, usually player
     * @param tileSize
     *      for scale
     */
    public Bullet(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize / 4, -10, "Bullet.png", 4);     //12x12
        //this.setPreferredSize(new Dimension(12, 12));  
    }
}
