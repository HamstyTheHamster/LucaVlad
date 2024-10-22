package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Tick implements ActionListener{
    Timer timer = new Timer(34, this);
    Map map;
    ArrayList<Entity> entities;
    
    public Tick(Map a, ArrayList<Entity> b) {
        entities = b;
        map = a;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was clicked!");
        if (map == null) {
            timer.stop();
        }
    }
}
