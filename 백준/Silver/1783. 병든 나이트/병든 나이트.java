import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(findAnswer(N, M));

        sc.close();
    }

    public static int findAnswer(int N, int M) {
        if (N == 1) {
            return 1;
        }
        if (N == 2){ 
            return Math.min(4, (M + 1) / 2);
        }
        if (M < 7) {
            return Math.min(4, M);
        }
        return M - 2; 
    }
}
