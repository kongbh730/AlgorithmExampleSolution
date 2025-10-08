import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N, M;

        N = sc.nextLong();
        M = sc.nextLong();

        sc.close();

        System.out.println(N * M / 2);
    }
}
