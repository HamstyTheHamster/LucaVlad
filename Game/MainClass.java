import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Salut Lume");
        Scanner scan = new Scanner(System.in);
        System.out.println("Scrie numele tau:");
        String name = scan.nextLine();
        System.out.println("Salut! " + name);
    } 
}