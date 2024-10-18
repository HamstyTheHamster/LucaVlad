package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Entity extends JPanel implements ActionListener{
    int x;
    int y;
    int step; // displacement at time step (~speed)
    Timer timer;
    Image img;
    int tSize;
    
    public Entity(int startx, int starty, int tileSize, int stepSize, String poza) {
        x = startx;
        y = starty;
        tSize = tileSize;
        step = stepSize;
        img = new ImageIcon(getClass().getResource(poza)).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) { //to draw pic
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //when event step
        this.step();
    }

    public void step() { //how to step
        y = y + step;
    }

}