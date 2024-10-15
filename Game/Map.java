package Game;

import java.awt.*;
import javax.swing.JPanel;

public class Map extends JPanel{
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576px



    //MovingRedObject player = new MovingRedObject();

    
    MovingRedObject player = new MovingRedObject();
    player.setBackground(Color.RED);
    player.setPreferredSize(new Dimension(20, 40));  // dimensiuni obiect
    player.setBounds(x, y, 20, 40);  // pozitia obiectului

    this.add(player);

    public Map(){ //constructor
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
}
}
