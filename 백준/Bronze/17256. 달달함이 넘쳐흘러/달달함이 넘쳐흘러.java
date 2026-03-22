import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ax,ay,az,cx,cy,cz;

        ax = sc.nextInt();
        ay = sc.nextInt();
        az = sc.nextInt();
        cx = sc.nextInt();
        cy = sc.nextInt();
        cz = sc.nextInt();
        sc.close();

        System.out.println((cx - az) + " " + (cy / ay) + " " + (cz - ax));
    }
}
