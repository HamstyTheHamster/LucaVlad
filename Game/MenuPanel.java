package Game;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel{

    Image img;
    public MenuPanel(Run a) {
        img = new ImageIcon(getClass().getResource("Wall.png")).getImage();
        
        this.setPreferredSize(new Dimension(1280, 720));  
        // 24 x 384
        this.setBounds(0, 0, 1280, 720);

        this.add(button);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
