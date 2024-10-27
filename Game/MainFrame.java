package Game;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JFrame;


/**
 * Frame in which to add my game.
 */
public class MainFrame {

    private JFrame window;

    /**
     * Frame constructor.
     * @param score
     *      highscore which I must pass from menu.
     * @throws URISyntaxException
     *      never happens
     * @throws IOException
     *      never happens
     */
    public MainFrame(String score) throws URISyntaxException, IOException {

        window = new JFrame();
        window.setTitle("COD ZOMBIES 2D");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //window.setSize(800,500);
        window.setResizable(false);

        Map panel = new Map(window, score);
        window.add(panel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        


        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom behavior to close another object
                panel.tickClean();

                // Close the JFrame after handling the other object
                window.dispose();
            }
        });
    }

    


    public void show() {
        window.setVisible(true);
    }

}
