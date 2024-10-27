package Game;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import javax.swing.JFrame;

/**
 * Class containing main method.
 * takes no parameters
 * displays frame for menu
 */
public class Run {
    JFrame window = new JFrame();

    /**
     * Constructor method to make the frame and put the elements in it.
     * Takes no input.
    * @throws FileNotFoundException
    *      never happens
    * @throws URISyntaxException
    *      never happens
    */
    public Run() throws FileNotFoundException, URISyntaxException {
        window.setTitle("COD ZOMBIES 2D");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //window.setSize(800,500);
    
        window.setResizable(false);

        MenuPanel panel = new MenuPanel(window);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    public void show() {
        window.setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Run run = new Run();
        run.show();
    
    }
        
}
