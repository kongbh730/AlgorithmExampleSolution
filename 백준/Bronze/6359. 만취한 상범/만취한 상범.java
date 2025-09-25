import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int T = sc.nextInt();

        for (i = 0; i < T; i++) {
            int n = sc.nextInt();
            int answer = (int) Math.sqrt(n);
            System.out.println(answer);
        }

        sc.close();
    }
}
