package MyPackage;

import javax.swing.JFrame;



public class MainWindow {

    private JFrame window;

    public MainWindow() {

        window = new JFrame();
        window.setTitle("COD ZOMBIES 2D");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        MyPanel panel = new MyPanel();
        
        window.add(panel);
        window.pack();
        
    }


    public void show() {

        window.setVisible(true);
    }

}
