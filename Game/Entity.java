package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Entity {
    int x;
    int y;
    int size; // diameter in pixels
    int step = 5; // displacement at time step (~speed)
    
    public Entity() {
        size = 30;
    }
    
    public Entity( int startx, int starty ) {
        x = startx;
        y = starty;
        size = 30;
    }
    
    public void step() {
        y += step;
    }

    void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
}