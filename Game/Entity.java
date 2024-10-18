package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Entity {
    int x;
    int y;
    int step; // displacement at time step (~speed)
    Timer timer;
    
    public Entity(int startx, int starty, int stepSize) {
        x = startx;
        y = starty;
        step = stepSize;
        size = 30;
    }
    
    /*public void step() {
        y += step;
    }
        */

    void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
}