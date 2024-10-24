package Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run extends JFrame{
    window = new JFrame();
    window.setTitle("COD ZOMBIES 2D");
    window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //window.setSize(800,500);
    
    window.setResizable(false);

    MenuPanel panel = new MenuPanel(this);
    window.add(panel);
    window.pack();
    window.setLocationRelativeTo(null);
        
        
}
