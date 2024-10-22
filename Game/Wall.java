package Game;

//walls for the game (could have drawn into the map realised too late)

import java.awt.*;
import javax.swing.*;



public class Wall extends JPanel{
    private int x;        
    private int y;       
    private int screenWidth;
    private int screenHeight;
    private int  tileSize;
    private Image img;

    public Wall(int posX, int scrW, int scH, int tile) {
        screenWidth = scrW;
        screenHeight = scH;
        tileSize = tile;
        x = posX;
        y = 0;
        img = new ImageIcon(getClass().getResource("Wall.png")).getImage();
        
        this.setPreferredSize(new Dimension(screenWidth / 32, screenHeight - 4 * tileSize));  
        // 24 x 384
        this.setBounds(x, y, screenWidth / 32, screenHeight - 4 * tileSize); 
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
    
}
