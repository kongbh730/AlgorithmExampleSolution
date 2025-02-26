import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        findAnswer(N, M);
    }

    public static void findAnswer(int N, int M) {
        int[][] square = new int[N][N];
        int num = N * N;
        int x = 0, y = 0; // 시작 위치
        int row = 0, col = 0; // M의 위치 저장

        // 방향 (↓, →, ↑, ←) 순서로 이동
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0;

        while (num > 0) {
            square[x][y] = num; // 현재 위치에 숫자 채우기
            if (num == M) {
                row = x + 1;
                col = y + 1;
            }

            // 다음 위치 계산
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 범위를 벗어나거나 이미 채워진 경우 방향 변경
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || square[nx][ny] != 0) {
                direction = (direction + 1) % 4; // 방향 전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            // 위치 업데이트
            x = nx;
            y = ny;
            num--;
        }

        // **StringBuilder 사용하여 출력 최적화**
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(square[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(row + " " + col);
    }
}
