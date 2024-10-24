package Game;

//event manager for game logic

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


/*
 * manages game evens 
 */
public class Tick implements ActionListener{
    Timer timer = new Timer(34, this);
    Map map;
    ArrayList<Zombie> zombies;
    
    ArrayList<Bullet> bullets;
    /**
     * constructor takes the map in which to manage the zombies and bullets as well as their lists.
     */
    public Tick(Map a, ArrayList<Zombie> z, ArrayList<Bullet> b) {
        zombies = z;
        bullets = b;
        map = a;
        timer.start();
    }

    public void tickClean(){
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was clicked!");
        
            
        for (Zombie i : zombies) {
            i.step();
            i.repaint();
            System.out.println();       
        }

        for (Bullet i : bullets) {
            i.step();
            i.repaint();
            System.out.println();       
        }
        
        this.checkCollisions();
        
    }


    private void checkCollisions(){
        for (Bullet i : bullets) {

            for (Zombie j: zombies) {
                if (j.isCollidingWith(i)) {
                    bullets.remove(i);
                    zombies.remove(j);
                    map.remove(i);
                    map.remove(j);
                    map.revalidate();
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

