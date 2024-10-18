package Game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;



public class Wall extends JPanel{
    private int x;        
    private int y;       
    private int screenWidth;
    private int screenHeight;
    private int  tileSize;

    public Wall(int posX, int scrW, int scH, int tile) {
        screenWidth = scrW;
        screenHeight = scH;
        tileSize = tile;
        x = posX;
        y = 0;
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(screenWidth / 32, screenHeight - 4 * tileSize));  
        // 24 x 384
        this.setBounds(x, y, screenWidth / 32, screenHeight - 4 * tileSize);  // pozitia obiectului
    }

}
