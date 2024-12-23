package Game;

//Player for the game

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Player class with key listener.
 */
public class Player extends JPanel implements KeyListener {

    private int x;        // pozitie initiala
    private int y;       // Poziția initială 
    private int screenWidth;
    private int screenHeight;
    private int  tileSize;
    private Map map;
    private Image img;

    /**
     * Creates a player.
     * @param a
     *      screen width
     * @param b
     *      screen height
     * @param c
     *      tile for scale
     * @param m
     *      adress of map to call bullets
     */
    public Player(int a, int b, int c, Map m) {
        screenWidth = a;
        screenHeight = b;
        tileSize = c;
        map = m;
        x = screenWidth / 2 - tileSize / 2;
        y = screenHeight - 2 * tileSize;
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(tileSize, tileSize));  // dimensiuni obiect
        
        this.setFocusable(true);
        this.addKeyListener(this);

        img = new ImageIcon(getClass().getResource("Player.png")).getImage();
        
        this.setPreferredSize(new Dimension(tileSize, tileSize));  
        // 24 x 384
        this.setBounds(x, y, tileSize, tileSize);  // pozitia obiectului
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {   
            //player movement and shooting
            
            case KeyEvent.VK_W:
                y -= 10;  // sus
                break;
            case KeyEvent.VK_S:
                y += 10;  // jos
                break;
            
            case KeyEvent.VK_A:
                x -= 10;  // stanga
                break;
            case KeyEvent.VK_D:
                x += 10;  // dreapta
                break;
            case KeyEvent.VK_SPACE:
                //shooting
                map.addBullet();
                break;
            default:
                
        }

        if (x < 0) { 
            x = 0;
        }
        if (y < screenHeight - 4 * tileSize + 4) {
            y = screenHeight - 4 * tileSize + 4;
        }
        if (x > screenWidth - this.getWidth()) {
            x = screenWidth - this.getWidth();
        }
        if (y > screenHeight - this.getHeight()) {
            y = screenHeight - this.getHeight();
        }

        this.setBounds(x, y, tileSize, tileSize); // pozitia noua
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

    
