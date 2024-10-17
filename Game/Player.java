package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Player extends JPanel implements KeyListener {

    //private JPanel bluePanel;  // panel saptiu
    //private JPanel redObject;  // panel obiect
    private int x;        // pozitie initiala
    private int y;       // Poziția initială 
    private int screenWidth;
    private int screenHeight;
    private int  tileSize;

    public Player(int a, int b, int c) {
        screenWidth = a;
        screenHeight = b;
        tileSize = c;
        x = screenWidth / 2 - tileSize / 2;
        y = screenHeight - 2 * tileSize;
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(tileSize, tileSize));  // dimensiuni obiect
        this.setBounds(x, y, tileSize, tileSize);  // pozitia obiectului
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    

    /*public MovingRedObjectExample(int width, int height) {
        setTitle("Red Object Moving with WASD");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);  

        // panelul albastru
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(0, 0, width, height);  // dimensiuni panel
        bluePanel.setLayout(null); 

        // obiectul roșu
        redObject = new JPanel();
        redObject.setBackground(Color.RED);
        redObject.setPreferredSize(new Dimension(20, 40));  // dimensiuni obiect
        redObject.setBounds(x, y, 20, 40);  // pozitia obiectului

        bluePanel.add(redObject);

        add(bluePanel); 

        addKeyListener(this);
        setFocusable(true);  

        setVisible(true);
        setLocationRelativeTo(null);
    }
    */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {   //player movement and shooting
            /*
            case KeyEvent.VK_W:
                y -= 10;  // sus
                break;
            case KeyEvent.VK_S:
                y += 10;  // jos
                break;
            */
            case KeyEvent.VK_A:
                x -= 10;  // stanga
                break;
            case KeyEvent.VK_D:
                x += 10;  // dreapta
                break;
                /*case KeyEvent.VK_SPACE:
                //shooting
                break;
                */
        }

        if (x < 0) { 
            x = 0;
        }
        if (y < 0){
            y = 0;
        }
        if (x > screenWidth - this.getWidth()){
            x = screenWidth - this.getWidth();
        }
        if (y > screenHeight - this.getHeight()) {
            y = screenHeight - this.getHeight();
        }

        this.setBounds(x, y, tileSize, tileSize); // pozitia noua
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*public static void main(String[] args) {
        
        new MovingRedObjectExample(800, 600);
    }
         */
}

    
