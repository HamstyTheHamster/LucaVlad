package Game;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;

/**
 * Panel for main menu.
 */
public class MenuPanel extends JPanel {
    URL url;
    URI uri;
    File file;
    Image img;
    JButton button;
    Graphics2D g2d;
    Scanner scanner;
    String score;
    JFrame frame;

    /**
     * Generates the menu.
     * @param a
     *      adress to frame so it can close it
     * @throws FileNotFoundException
     *      never happens
     * @throws URISyntaxException
     *      never happens
     */
    public MenuPanel(JFrame a) throws FileNotFoundException, URISyntaxException {
        url = MenuPanel.class.getResource("highscore.txt");
        uri = url.toURI();
        file = new File(uri);
        scanner = new Scanner(file);
        
        img = new ImageIcon(getClass().getResource("Menu.jpg")).getImage();
        if (scanner.hasNext()) {
            score = scanner.next();
        }
        frame = a;
        this.setPreferredSize(new Dimension(1280, 720));  
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        button = new JButton("START GAME");
        
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        MainFrame main;
                        try {
                            main = new MainFrame(score);
                            main.show();
                        } catch (URISyntaxException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        
                    }
                });
                
                System.out.println("Button was clicked!");
            }
        });

        //button.setBounds(this.getWidth() / 2 - 50, this.getHeight() / 2 - 25, 100, 50);
        button.setBounds(1280 / 2 - 50 - 200, 720 / 2 - 25, 400, 50);
        this.add(button);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.setColor(Color.GREEN);
        g2d.drawString("HIGH SCORE: " + score,
                this.getWidth() / 2 - 200, this.getHeight() / 2 + 60);
        g2d.setColor(Color.GREEN);
        g2d.drawString("PARICI VLAD 2112744", 10, 30);
        g2d.drawString("ANDREI LUCA 2125447", 10, 50);
    }
}