import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int p = 0; p < T; p++) {
            int n = sc.nextInt(); // 팀 수
            int k = sc.nextInt(); // 문제 수
            int t = sc.nextInt(); // 내 팀 ID
            int m = sc.nextInt(); // 로그 수

            int[][] teams = new int[n + 1][k + 1]; // 각 문제 최고점
            int[] submitCnt = new int[n + 1];
            int[] lastTime = new int[n + 1];

            for (int q = 0; q < m; q++) {
                int i = sc.nextInt(); // 팀 id
                int j = sc.nextInt(); // 문제 번호
                int s = sc.nextInt(); // 점수

                submitCnt[i]++;        // 제출 횟수 증가
                lastTime[i] = q;       // 마지막 제출 시간 갱신(입력 순서가 시간)

                if (s > teams[i][j]) { // 최고점 갱신
                    teams[i][j] = s;
                }
            }

            int[] total = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++){
                    sum += teams[i][j];
                }
                total[i] = sum;
            }

            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i + 1;
            }

            Arrays.sort(ids, (a, b) -> {
                if (total[a] != total[b]) {
                    return Integer.compare(total[b], total[a]);      // 점수 내림차순
                }
                if (submitCnt[a] != submitCnt[b]) {
                    return Integer.compare(submitCnt[a], submitCnt[b]); // 제출 오름차순
                }
                return Integer.compare(lastTime[a], lastTime[b]);                          // 시간 오름차순
            });

            int rank = 0;

            for (int idx = 0; idx < n; idx++) {
                if (ids[idx] == t) {
                    rank = idx + 1;
                    break;
                }
            }

            System.out.println(rank);
        }

        sc.close();
    }
}
