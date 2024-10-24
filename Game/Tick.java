package Game;

//event manager for game logic

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD

/*
 * manages game evens 
 */
public class Tick implements ActionListener{
=======
public class Tick extends JPanel implements ActionListener{
>>>>>>> d60a4bf2cb67e8804ce5f21d541d90844a442cc6
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


<<<<<<< HEAD
    private void checkCollisions(){
        for (Bullet i : bullets) {

            for (Zombie j: zombies) {
                if (j.isCollidingWith(i)) {
                    
                }

            }

        }

=======
    private void checkCollisions() {
        for (Entity i : entities) {
            if (i instanceof Bullet) {
                Bullet bullet = (Bullet) i;
                for (Entity j : entities) {
                    if (j instanceof Zombie) {
                        Zombie zombie = (Zombie) j;
                        if(zombie.isCollidingWith(bullet)){
                            entities.remove(zombie);
                            entities.remove(bullet);
                            repaint();
                                
                        }
                        
                        // entities.remove(bullet);

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
>>>>>>> d60a4bf2cb67e8804ce5f21d541d90844a442cc6
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

