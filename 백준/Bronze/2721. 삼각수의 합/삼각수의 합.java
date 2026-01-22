import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int T, n, i, j;
        long W;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (i = 0; i < T; i++) {
            n = sc.nextInt();
            W = 0;

            for (j = 1; j <= n; j++) {
                long tri = (long)(j + 1) * (j + 2) / 2;
                W += (long) j * tri;
            }

            System.out.println(W);
        }
        sc.close();
    }
}
