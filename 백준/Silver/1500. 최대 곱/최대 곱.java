import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S, K, i;

        S = sc.nextInt();
        K = sc.nextInt();
        sc.close();

        int q = S / K;
        int r = S % K;

        BigInteger answer = BigInteger.ONE;

        for(i = 0; i < K - r; i++){
            answer = answer.multiply(BigInteger.valueOf(q));
        }
        for(i = 0; i < r; i++){
            answer = answer.multiply(BigInteger.valueOf(q + 1));
        }

        System.out.println(answer.toString());
    }
}
