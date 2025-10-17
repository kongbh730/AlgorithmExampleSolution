import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        BigInteger[] f = new BigInteger[n + 1];
        f[0] = BigInteger.ZERO;
        f[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }

        System.out.println(f[n]);
    }
}
