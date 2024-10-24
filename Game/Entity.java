package Game;

//entity wich can display picture have bound and move

import java.awt.*;
import javax.swing.*;

class Entity extends JPanel {
    int x;
    int y;
    int step; // displacement at time step (~speed)
    Image img;
    int tSize;
    int size;
    public Entity(int startx, int starty, int tileSize, int stepSize, String poza, int sizeL) {
        x = startx;
        y = starty;
        tSize = tileSize;
        step = stepSize;
        size = sizeL;
        img = new ImageIcon(getClass().getResource(poza)).getImage();
        this.setPreferredSize(new Dimension(size, size));
        this.setBounds(x, y, size, size);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
     
    @Override
    protected void paintComponent(Graphics g) { //to draw pic
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }



    public void step() { //how to step
        y = y + step;
        this.setBounds(x, y, size, size);
    }


    

}