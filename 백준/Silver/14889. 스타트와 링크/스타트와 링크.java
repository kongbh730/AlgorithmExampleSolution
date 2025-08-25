import java.util.Scanner;

public class Main {
    static int [][] StartLink;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) {
        inputData();
        combination(1, 0);
        System.out.println(minDiff);
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i, j;

        N = sc.nextInt();
        StartLink = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                StartLink[i][j] = sc.nextInt();
            }
        }

        sc.close();
    }

    //두 팀으로 나누는 조합
    public static void combination(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }
        if (idx > N){
            return;
        }

        visited[idx] = true;
        combination(idx + 1, count + 1);

        visited[idx] = false;
        combination(idx + 1, count);
    }

    public static void calculateDifference() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    startScore += StartLink[i][j];
                }
                if (!visited[i] && !visited[j]) {
                    linkScore += StartLink[i][j];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(startScore - linkScore));
    }
}
