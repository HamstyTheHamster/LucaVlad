package Game;

/**
 * zombie to add to map.
 */
public class Zombie extends Entity {
    
    public Zombie(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize, 1, "Zombie.png", 36);
    }

    /**
     * determines wether the zombie is touched by the bullet.
     * @param bullet
     *      a bullet to check wether it is inside the zombie
     * @return
     *      true if inside the zombie, false if not
     */
    boolean isCollidingWith(Bullet bullet) {
        if (bullet.getX() >= this.x 
            && bullet.getX() <= this.x + 36
            && bullet.getY() >= this.y
            && bullet.getY() <= this.y + 36) {
            return true;
        }
        return false;
    }
}
