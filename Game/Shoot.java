package Game;



//NOT USED ANYMORE (CANT HAVE MORE THAN ONE KEYLISTENERS IN MAP SO I MOVED IT TO PLAYER)
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shoot implements KeyListener{

    Map map;

    public Shoot(Map a) {
        map = a;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("test");
            map.addBullet();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    

}
