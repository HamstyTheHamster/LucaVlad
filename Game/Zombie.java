package Game;

public class Zombie extends Entity{
    
    public Zombie(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize, 1, "Zombie.png", 36);
    }

    boolean isCollidingWith (Bullet bullet){
        if (bullet.getX() >= this.x &&
            bullet.getX() <= this.x + 36 &&
            bullet.getY() >= this.y &&
            bullet.getY() <= this.y) {
            return true;
        }
        return false;
    }
}
