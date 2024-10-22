package Game;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;



public class MainFrame {

    private JFrame window;

    public MainFrame() {

        window = new JFrame();
        window.setTitle("COD ZOMBIES 2D");
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        Map panel = new Map();
        window.add(panel);
        window.pack();
        


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
