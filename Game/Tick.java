package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/*
 * Manages game events
 */
public class Tick implements ActionListener {
    Timer timer = new Timer(31, this); // Timer to trigger updates every 31ms
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

    public void tickClean() {
        timer.stop();  // Stop the timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check for collisions first, so that zombies are removed immediately
        this.checkCollisions();

        // Update all zombies and bullets
        for (Zombie i : zombies) {
            i.step();
            i.repaint();
        }

        for (Bullet i : bullets) {
            i.step();
            i.repaint();
        }
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
                    // Remove from map immediately to avoid further movement
                    map.remove(bullet);
                    map.remove(zombie);
                }
            }
        }

        // Remove collided bullets and zombies from the list
        bullets.removeAll(bulletsToRemove);
        zombies.removeAll(zombiesToRemove);

        // Refresh the display after removal
        map.revalidate();
        map.repaint();
    }
}
