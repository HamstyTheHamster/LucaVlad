package Game;

public class Bullet extends Entity{
    
    public Bullet(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize / 4, -50, "Bullet.png");     //12x12
    }
}
