import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long [][]DP = new long[100001][4];

    public static void main(String[] args) {
        int T, i, temp;

        T = sc.nextInt();
        makeDP();
        for (i = 0; i < T; i++) {
            temp = sc.nextInt();
            System.out.println(findAnswer(temp));
        }

        sc.nextLine();
    }

    public static void makeDP() {
        //System.out.println("makeDP()");
        int i;
        int MOD = 1000000009;
        /*
                  0 1 2 3 4 5 6 7 8 9 ...
        * 1 시작 : 0 1 0 1 2
        * 2 시작 : 0 0 1 1 0
        * 3 시작 : 0 0 0 1 1
                  1 1 1 3
        */
        DP[1][1] = 1;
        //DP[1][2] = 0;
        //DP[1][3] = 0;
        //DP[2][1] = 0;
        DP[2][2] = 1;
        //DP[2][3] = 0;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;

        for(i = 4; i < DP.length; i++) {
            DP[i][1] = (DP[i-1][2] + DP[i-1][3]) % MOD;
            DP[i][2] = (DP[i-2][1] + DP[i-2][3]) % MOD;
            DP[i][3] = (DP[i-3][1] + DP[i-3][2]) % MOD;
            //System.out.println(DP[i][1] + " " + DP[i][2] + " " + DP[i][3]);
        }
    }

    public static long findAnswer(int n) {
        //System.out.println("findAnswer()");
        long answer = 0;
        int MOD = 1000000009;

        answer = (DP[n][1] + DP[n][2] + DP[n][3]) % MOD;

        return answer;
    }
}
