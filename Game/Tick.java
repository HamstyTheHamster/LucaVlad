package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane; 
import javax.swing.Timer;

/**
 * Tickrate manager.
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
    File file;
    URL url;
    String fileContent;
    URI uri;
    FileWriter writer;
    String highscore;

    /**
     * Constructor takes the map, and lists of zombies and bullets.
     * @throws URISyntaxException 
     *      it wont happen
     * @throws IOException
     *      it wont happen 
     */
    public Tick(Map a, ArrayList<Zombie> z, ArrayList<Bullet> b, String highscore) 
                    throws URISyntaxException, IOException {
        url = MenuPanel.class.getResource("highscore.txt");
        uri = url.toURI();
        file = new File(uri);
        writer = new FileWriter(file);
        this.highscore = highscore;
        System.out.println(highscore);
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
            JOptionPane.showMessageDialog(map, "You lose! \n" + "SCORE: "
                + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            tickClean();
            map.window.dispose();
            fileContent = "" + score;
            
            if (highscore == null) {
                highscore = "0";
            }

            if (Integer.parseInt(highscore) < score) {
                try {
                    writer.write(fileContent);
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
               
            } else {
                try {
                    writer.write(highscore);
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
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
            if (cnt % (rate * 5) == 0 && cnt > 25) {
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

    /**
     * Determine if the zombie has gone far enough for you to lose.
     * @param a
     *      the zombie on which to check the loss condition
     * @return
     *      true if you lose
     *      false if you dont
     */
    public boolean lose(Zombie a) {

        if (a.getY() > map.screenHeight * 2 / 3 - map.tileSize / 2) {
            return true;
        }
        return false;

    }
}
