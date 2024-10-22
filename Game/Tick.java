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
        
            
        for (Entity i : entities) {
            i.step();
            i.repaint();
            System.out.println();       
        }
        this.checkCollisions();
        
    }


    private void checkCollisions() {
        for (Entity i : entities) {
            if (i instanceof Bullet) {
                Bullet bullet = (Bullet) i;
                for (Entity j : entities) {
                    if (j instanceof Zombie) {
                        Zombie zombie = (Zombie) j;
                        System.out.println(zombie.isCollidingWith(bullet));
                        // if (zombie.isCollidingWith(bullet)) {
                        //     zombie.isCollidingWith(bullet)
                        //     entities.remove(zombie);
                        //     entities.remove(bullet);
                        //     // It's a good idea to break out of the loop after removing the bullet
                        //     break;
                        // }
                    }
                }
            }
        }
    }
    
    // private void checkCollisions() {
    //     for (int i = 0; i < player.getBullets().size(); i++) {
    //         Bullet bullet = player.getBullets().get(i);
    //         for (int j = 0; j < zombies.size(); j++) {
    //             Zombie zombie = zombies.get(j);
    //             if (bullet.isCollidingWith(zombie)) {
    //                 zombies.remove(j);
    //                 player.getBullets().remove(i);
    //                 i--; 
    //                 break; 
    //             }
    //         }
    //     }
    // }
}

