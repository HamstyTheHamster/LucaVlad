package Game;

/**
 * bullet, a type of entity.
 */
public class Bullet extends Entity {

    /**
     * Creates bullet in desired spot according to scale.
     * @param startx
     *      spawn x
     * @param starty
     *      spawn y
     * @param tileSize
     *      scale
     */
    public Bullet(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize / 4, -10, "Bullet.png", 4);     //12x12
        //this.setPreferredSize(new Dimension(12, 12));  
    }
}
