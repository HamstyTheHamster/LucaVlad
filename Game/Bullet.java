package Game;

import java.awt.Dimension;

public class Bullet extends Entity{
    
    public Bullet(int startx, int starty, int tileSize) {
        super(startx, starty, tileSize / 4, -50, "Bullet.png", 12);     //12x12
        //this.setPreferredSize(new Dimension(12, 12));  
    }
}
