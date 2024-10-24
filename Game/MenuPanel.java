package Game;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.swing.*;


public class MenuPanel extends JPanel{
    URL url;
    URI uri;
    File file;
    Image img;
    JButton button;
    Graphics2D g2d;
    Scanner scanner;
    String score;
    JFrame frame;

    public MenuPanel(JFrame a) throws FileNotFoundException, URISyntaxException{
        url = MenuPanel.class.getResource("highscore.txt");
        uri = url.toURI();
        file = new File(uri);
        scanner = new Scanner(file);

        img = new ImageIcon(getClass().getResource("Menu.jpg")).getImage();
        score = scanner.next();
        frame = a;
        this.setPreferredSize(new Dimension(1280, 720));  
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        button = new JButton("START GAME");
        button.setBounds(this.getWidth() / 2 - 50, this.getHeight() / 2 - 25, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        MainFrame main = new MainFrame();
                        main.show();
                    }
                });
                
                System.out.println("Button was clicked!");
            }
        });


        button.setBounds(this.getWidth() / 2 - 50, this.getHeight() / 2 - 25, 100, 50);
        this.add(button);
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.RED);
        g2d.drawString("HIGH SCORE: " + score, this.getWidth() / 2 - 200, this.getHeight() / 2 + 60);
    }
}