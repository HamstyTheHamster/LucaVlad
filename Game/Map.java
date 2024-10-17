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
    public Map() { // constructor
        
        player = new Player(screenWidth, screenHeight, tileSize);         //create player
        shoot = new Shoot();
        // Set up panel properties
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        // Add player to the panel
        this.add(player);
        this.addKeyListener(shoot);
        
    }

}
