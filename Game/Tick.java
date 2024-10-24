package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JOptionPane; 
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
    private boolean gameLost = false; 
    int rate = 65;

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
        if (gameLost) {
            return; 
        }

        
        checkCollisions();
        spawner();

        // Update all zombies and bullets
        for (Zombie i : zombies) {
            i.step();
            i.repaint();
        }

        for (Bullet i : bullets) {
            i.step();
            i.repaint();
        }

        
        if (checkGameLoss()) {
            gameLost = true; 
            JOptionPane.showMessageDialog(map, "You lose! \n" + "SCORE: " +
             score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            tickClean();
            map.window.dispose();
        }
    }

    
    private boolean checkGameLoss() {
        for (Zombie zombie : zombies) {
            if (lose(zombie)) {
                return true; 
            }
        }
        return false; 
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
        if (cnt % rate == 0) {
            int randomX = random.nextInt(map.screenWidth - map.tileSize);  
            int startY = -map.tileSize;  
            Zombie newZombie = new Zombie(randomX, startY, map.tileSize);
            map.add(newZombie);   
            if (cnt % (rate * 5) == 0 && cnt > 25){
                Zombie newZombie2 = new Zombie(randomX, startY + map.tileSize, map.tileSize);
                map.add(newZombie2);
                zombies.add(newZombie2);

                Zombie newZombie3 = new Zombie(randomX, startY + 2 * (map.tileSize), map.tileSize);
                map.add(newZombie3);
                zombies.add(newZombie3);
            }      
            zombies.add(newZombie);
            
            if (cnt % (rate * 10) == 0 && rate > 30) {
                rate = rate - 10;
             }
        }
        cnt++;
    }

    public int getScore() {
        return score;
    }

    public boolean lose(Zombie a) {

        if (a.getY() > map.screenHeight * 2 / 3 - map.tileSize / 2) {
            return true;
        }
        return false;

    }
}
