package Game;

//map on which we add all elements

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class Map extends JPanel {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576px

    Player player;
    //Shoot shoot;
    Wall wall1;
    Wall wall2;
    Wall wall3;
    Image img;
    Tick tick; //what happens every tick
    ArrayList<Zombie> zombies;
    ArrayList<Bullet> bullets;
    Graphics2D g2d;
    int score;
    JFrame window;

    public Map(JFrame w) { // constructor
        window = w;
        player = new Player(screenWidth, screenHeight, tileSize, this);         //create player
        //shoot = new Shoot(this);
        wall1 = new Wall(174, screenWidth, screenHeight, tileSize);
        wall2 = new Wall(372, screenWidth, screenHeight, tileSize);
        wall3 = new Wall(570, screenWidth, screenHeight, tileSize);
        img = new ImageIcon(getClass().getResource("Map.png")).getImage();

    
        zombies = new ArrayList<Zombie>();
        bullets = new ArrayList<Bullet>();
        tick = new Tick(this, zombies, bullets);
        
        // Set up panel properties
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        // Add elements to the panel
        //this.add(wall1);
        //this.add(wall2);
        //this.add(wall3);
        this.add(player);
        this.addKeyListener(player);
        addBullet();

    }

    public void addBullet(){
        Bullet bullet = new Bullet(player.getX() + tileSize/2, player.getY() + tileSize/2, tileSize);
        this.add(bullet);
        System.out.println("shooting");
        bullets.add(bullet);
    }


    public void addZombie(int x, int y) {
        Zombie zombie = new Zombie(x, y, tileSize);
        this.add(zombie);
        System.out.println("zombie");
        zombies.add(zombie);
    }

    public void removeZombie(Zombie i) {
        zombies.remove(i);
    }

    public void removeBullet(Bullet i) {
        bullets.remove(i);
    }

    public void tickClean() {
        tick.tickClean();
    }
    
    @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.BLUE);
        score = tick.getScore();
        g2d.drawString("SCORE: " + score, this.getWidth() - 130, 20);
    }

    
}