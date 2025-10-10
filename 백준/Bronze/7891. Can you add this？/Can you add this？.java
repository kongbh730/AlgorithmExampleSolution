import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int T, x, y, i;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            x = sc.nextInt();
            y = sc.nextInt();

            System.out.println(x + y);
        }
    }
}
