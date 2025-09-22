import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(i = 0; i < T; i++){
            int A, B;

            A = sc.nextInt();
            B = sc.nextInt();

            System.out.printf("Case %d: %d\n", i + 1, A + B);
        }

        sc.close();
    }
}
