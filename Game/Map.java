package Game;

import java.awt.*;
import javax.swing.JPanel;

public class Map extends JPanel {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576px
    Player player;
    Shoot shoot;
    Wall wall1;
    Wall wall2;
    Wall wall3;
    public Map() { // constructor
        
        player = new Player(screenWidth, screenHeight, tileSize);         //create player
        shoot = new Shoot(this);
        wall1 = new Wall(174, screenWidth, screenHeight, tileSize);
        wall2 = new Wall(372, screenWidth, screenHeight, tileSize);
        wall3 = new Wall(570, screenWidth, screenHeight, tileSize);



        // Set up panel properties
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        // Add player to the panel
        this.add(wall1);
        this.add(wall2);
        this.add(wall3);
        this.add(player);
        this.addKeyListener(shoot);

        

        
        
    }

    /*public void addBullet(Entity bullet){
        this.add(bullet);
    }
        */

}

/*class Test {
    Test(Map p) {

    }
}
    */