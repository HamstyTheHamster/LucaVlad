package Game;

public class Zombie extends Entity{
    
    public Zombie(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize, 1, "Zombie.png", 36);
    }

    public boolean isCollidingWith(Bullet bullet) {
        return (this.x < bullet.x + bullet.size && this.x + this.size > bullet.x &&
        this.y < bullet.y + bullet.size && this.y + this.size > bullet.y);
    }
}
