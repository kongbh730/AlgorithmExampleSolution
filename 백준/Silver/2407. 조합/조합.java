import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m, i;
        BigInteger answer = BigInteger.valueOf(1);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.close();

        //반복문 연산횟수를 줄일 수 있음
        if (m > n - m) {
            m = n - m;
        }

        for (i = 0; i < m; i++) {
            answer = answer.multiply(BigInteger.valueOf(n - i));
            answer = answer.divide(BigInteger.valueOf(i + 1));
        }

        System.out.println(answer);
    }
}
