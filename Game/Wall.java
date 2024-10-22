package Game;

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
        img = new ImageIcon(getClass().getResource("Wall.png")).getImage();
        y = 0;
        
        this.setPreferredSize(new Dimension(screenWidth / 32, screenHeight - 4 * tileSize));  
        // 24 x 384
        this.setBounds(x, y, screenWidth / 32, screenHeight - 4 * tileSize);  // pozitia obiectului
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

}
