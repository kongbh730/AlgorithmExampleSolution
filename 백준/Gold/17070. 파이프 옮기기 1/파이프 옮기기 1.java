import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static boolean[][] house;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int i, j;

        N = sc.nextInt();
        house = new boolean[N + 1][N + 1];
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                house[i][j] = (sc.nextInt() == 1);
            }
        }
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");
        int i, j;
        int[][][] DP = new int[N + 1][N + 1][3];

        // 초기 상태 설정: (1, 2)에 가로 방향으로 놓인 상태에서 시작
        DP[1][2][0] = 1;

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                // 벽이 있는 경우, 이 위치로 올 수 없음
                if (house[i][j]) continue;

                // 가로로 이동
                if (j - 1 >= 1) {
                    DP[i][j][0] += DP[i][j - 1][0] + DP[i][j - 1][2];
                }

                // 세로로 이동
                if (i - 1 >= 1) {
                    DP[i][j][1] += DP[i - 1][j][1] + DP[i - 1][j][2];
                }

                // 대각선으로 이동
                if (i - 1 >= 1 && j - 1 >= 1 && !house[i - 1][j] && !house[i][j - 1]) {
                    DP[i][j][2] += DP[i - 1][j - 1][0] + DP[i - 1][j - 1][1] + DP[i - 1][j - 1][2];
                }
            }
        }

        // 최종 도착점에서 모든 방향의 값을 합산
        return DP[N][N][0] + DP[N][N][1] + DP[N][N][2];
    }
}
