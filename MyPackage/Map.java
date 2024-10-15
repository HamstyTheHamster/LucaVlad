package MyPackage;

import java.awt.FlowLayout;
import java.io.File;
import java.util.Scanner;
import javax.swing.JPanel;


public class Map extends JPanel{
    int a;
    File file = new File("map.txt");
    Scanner scan = new Scanner(file);
    
    public Map(){
        //this.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        this.setLayout(new GridLayout(10, 15));
        this.setBackground(Color.BLACK);
        for (int i = 1; i <= 150; i++) {
            a = scan.nextInt();
            if (a == 0) {

            } else if (a == 1){

            } else if (a == 2){

            }
        }
    }

}
