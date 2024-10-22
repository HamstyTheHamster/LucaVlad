package Game;

//event manager for game logic

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Tick implements ActionListener{
    Timer timer = new Timer(34, this);
    Map map;
    ArrayList<Entity> entities;
    Entity enti;
    
    public Tick(Map a, ArrayList<Entity> b) {
        entities = b;
        map = a;
        timer.start();
    }

    public void tickClean(){
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was clicked!");
        if (entities != null) {
            
            for (Entity i : entities) {
                i.step();
            }
        }
    }
}
