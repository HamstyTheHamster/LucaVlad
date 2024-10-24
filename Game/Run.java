package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run extends JFrame{
    this.setTitle("COD ZOMBIES 2D");
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //window.setSize(800,500);
    
    this.setResizable(false);

    MenuPanel panel = new MenuPanel(this);
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
        
        
}
