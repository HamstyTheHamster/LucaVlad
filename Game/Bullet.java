package Game;


public class Bullet extends Entity{
    
    public Bullet(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize / 4, -10, "Bullet.png", 4);     //12x12
        //this.setPreferredSize(new Dimension(12, 12));  
    }
}
