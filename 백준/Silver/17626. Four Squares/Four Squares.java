import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        N = sc.nextInt();
        System.out.println(findAnswer(N));

        sc.close();
    }

    public static int findAnswer(int N) {
        int min, temp;
        int [] DP = new int[N+1];
        int i, j;

        DP[1] = 1;
        for(i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for(j = 1; j * j <= i; j++) {
                temp = i - j * j;
                min = Math.min(min, DP[temp]);
            }
            DP[i] = min + 1;
            //System.out.print(DP[i] + " ");
        }
        //System.out.println();

        return DP[N];
    }
}
