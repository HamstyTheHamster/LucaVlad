package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shoot implements KeyListener{

    public Shoot() {
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("test");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    

}
