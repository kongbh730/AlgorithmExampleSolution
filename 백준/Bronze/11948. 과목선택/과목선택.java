import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int E = sc.nextInt();
        int F = sc.nextInt();

        sc.close();

        int maxScience = A + B + C + D - Math.min(Math.min(A, B),Math.min(C, D));
        int maxHistoryGeo = Math.max(E, F);

        System.out.println(maxScience + maxHistoryGeo);
    }
}
