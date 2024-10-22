package Game;


import javax.swing.JFrame;



public class MainFrame {

    private JFrame window;

    public MainFrame() {

        window = new JFrame();
        window.setTitle("COD ZOMBIES 2D");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        Map panel = new Map();
       window.add(panel);
       window.pack();
        
    }


    public void show() {

        window.setVisible(true);
    }

}
