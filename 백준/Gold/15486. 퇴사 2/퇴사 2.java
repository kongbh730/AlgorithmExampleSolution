import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] T; // 상담을 완료하는데 걸리는 기간 T
    static int [] P; // 완료하면 받을 수 있는 금액 P
    static int N;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int i, p, t;

        N = sc.nextInt();
        T = new int[N + 2];
        P = new int[N + 2];
        for(i = 1; i <= N; i++) {
            t = sc.nextInt();
            p = sc.nextInt();
            T[i] = t;
            P[i] = p;
        }
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");
        int i, currentMaxIncome = Integer.MIN_VALUE, nextDay;
        //N이 7이면 8일에 퇴사하고, 7일차에 1일 걸리는 상담을 할 수 있음
        //퇴사날 최대 값을 얻어야 하니까 N이 7이면 DP[8]을 구해야 함
        int [] DP = new int[N + 2];

        for(i = 1; i <= N + 1; i++) { //1일부터 N + 1일까지 중 i일
            if(currentMaxIncome < DP[i]){//기존 저장된 값(전에 있었던 상담을 마무리해서 얻은 수익)이 i일에 저장된 수익보다 크다면?
                currentMaxIncome = DP[i];//최대 수익 갱신
            }

            nextDay = i + T[i];
            if(nextDay < N + 2){//퇴사날을 초과하지 않는다면
                //상담이 끝난 날 = max(기존 저장된 값, i일에 시작한 상담이 끝날 경우 얻는 수익 + i일까지 얻을 수 있는 최대 수익)
                DP[nextDay] = Math.max(P[i] + currentMaxIncome, DP[nextDay]);
            }

//            System.out.print(i + "회차 : ");
//            for(int dp : DP){
//                System.out.print(dp + " ");
//            }
//            System.out.println();
        }

        return DP[N + 1];
    }
}
