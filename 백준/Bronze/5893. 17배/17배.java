import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String N = "";
        Scanner sc = new Scanner(System.in);

        N = sc.next();
        String decimal = new BigInteger(N, 2).multiply(BigInteger.valueOf(17)).toString(10);
        String binary = new BigInteger(decimal).toString(2);

        System.out.println(binary);
    }
}
