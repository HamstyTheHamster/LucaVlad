package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/*
 * Manages game events
 */
public class Tick implements ActionListener {
    Timer timer = new Timer(31, this); // Timer to trigger updates every 34ms
    Map map;
    ArrayList<Zombie> zombies;
    ArrayList<Bullet> bullets;

    /**
     * Constructor takes the map, and lists of zombies and bullets.
     */
    public Tick(Map a, ArrayList<Zombie> z, ArrayList<Bullet> b) {
        zombies = z;
        bullets = b;
        map = a;
        timer.start();  // Start the timer
    }

    public void tickClean(){
        timer.stop();  // Stop the timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update all zombies and bullets
        for (Zombie i : zombies) {
            i.step();
            i.repaint();
        }

        for (Bullet i : bullets) {
            i.step();
            i.repaint();
        }

        this.checkCollisions(); // Check for collisions between bullets and zombies
    }

    // Method to check and handle collisions between bullets and zombies
    private void checkCollisions() {
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
        ArrayList<Zombie> zombiesToRemove = new ArrayList<>();

        // Iterate through bullets and zombies to check for collisions
        for (Bullet bullet : bullets) {
            for (Zombie zombie : zombies) {
                if (zombie.isCollidingWith(bullet)) {
                    bulletsToRemove.add(bullet);
                    zombiesToRemove.add(zombie);
                }
            }
        }

        // Remove collided bullets and zombies
        bullets.removeAll(bulletsToRemove);
        zombies.removeAll(zombiesToRemove);

        // Remove objects from the map and refresh the display
        for (Bullet bullet : bulletsToRemove) {
            map.remove(bullet);
        }
        for (Zombie zombie : zombiesToRemove) {
            map.remove(zombie);
        }

        map.revalidate();
        map.repaint();  // Ensure the map is updated after removing objects
    }
}
