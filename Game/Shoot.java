package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shoot implements KeyListener{
Map map;

    public Shoot(Map a) {
        map = a;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            map.addBullet();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    

}
