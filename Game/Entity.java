package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Entity extends JPanel{
    int x;
    int y;
    int step; // displacement at time step (~speed)
    Timer timer;
    Image img;
    int tSize;
    
    public Entity(int startx, int starty, int tileSize, int stepSize) {
        x = startx;
        y = starty;
        step = stepSize;
        tSize = tileSize;
    }

    public void setPic(String poza) {
        img = new ImageIcon(getClass().getResource(poza)).getImage();
    }
    
    /*public void step() {
        y += step;
    }
        */



        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);  
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);


    /*void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
        */
}