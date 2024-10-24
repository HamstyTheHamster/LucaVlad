package Game;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class MenuPanel extends JPanel{
    File file = new File("highscore.txt");
    Image img;
    JButton button;
    Graphics2D g2d;
    Scanner scanner = new Scanner("highscore.txt");
    String score;

    public MenuPanel(Run a) {
        img = new ImageIcon(getClass().getResource("Menu.jpg")).getImage();
        score = scanner.next();

        this.setPreferredSize(new Dimension(1280, 720));  
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        button = new JButton("START GAME");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                a.dispose();
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
        g2d.setColor(Color.BLUE);
        score = tick.getScore();
        g2d.drawString("HIGH SCORE: " + score, this.getWidth() / 2 - 130, this.getHeight() + 60);
    }
}