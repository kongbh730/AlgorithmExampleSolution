import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A, B, C, D;

        A = sc.nextInt();
        B = sc.nextInt();

        C = sc.nextInt();
        D = sc.nextInt();

        sc.close();

        int case1 = B + C;
        int case2 = A + D;

        System.out.println(Math.min(case1, case2));
    }
}
