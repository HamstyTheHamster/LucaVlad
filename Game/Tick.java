package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import java.util.Random;

/*
 * Manages game events
 */
public class Tick implements ActionListener {
    Timer timer = new Timer(31, this); // Timer to trigger updates every 31ms
    Map map;
    ArrayList<Zombie> zombies;
    ArrayList<Bullet> bullets;
    Random random;
    int cnt;
    int score;

    /**
     * Constructor takes the map, and lists of zombies and bullets.
     */
    public Tick(Map a, ArrayList<Zombie> z, ArrayList<Bullet> b) {
        zombies = z;
        bullets = b;
        map = a;
        cnt = 0;
        score = 0;
        random = new Random();
        timer.start();  // Start the timer
    }

    public void tickClean() {
        timer.stop();  // Stop the timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check for collisions first, so that zombies are removed immediately
        this.checkCollisions();
        this.spawner();
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
                    score++;
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

    public void spawner() {
        if(cnt % 65 == 0) {
            int randomX = random.nextInt(map.screenWidth - map.tileSize);  
            int startY = -map.tileSize;  
    
            Zombie newZombie = new Zombie(randomX, startY, map.tileSize);
            map.add(newZombie);         
            zombies.add(newZombie);     
        }
        cnt++;
    }

    public static int getScore() {
        return score;
    }

}
