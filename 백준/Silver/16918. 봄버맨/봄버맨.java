import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int R, C, N;
    static char [][] table;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i, j;
        String temp;

        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();// N초가 지난 후 결과

        table = new char[R][C];
        for(i = 0; i < table.length; i++){
            temp = sc.next();
            for(j = 0; j < table[i].length; j++){
                table[i][j] = temp.charAt(j);
            }
        }

        sc.close();
    }

    public static void findAnswer() {
        // 그래프 문제가 아님
        // N = 1 이면 아무것도 안함
        // N = 2 이면 모든 구역에 폭탄이 설치됨
        // N = 3 이면 첫 폭탄만 터짐
        // N = 4 이면 모든 구역에 폭탄이 설치됨
        // N = 5 이면 첫 폭탄이 아닌 폭탄만 터짐
        // N = 6 이면 모든 구역에 폭탄이 설치됨
        // N = 7 이면 첫 폭탄만 터짐
        // N = 8 이면 모든 구역에 폭탄이 설치됨
        // N = 9 이면 첫 폭탄이 아닌 폭탄만 터짐
        if (N == 1) {
            printMap(table);
            return;
        }

        if (N % 2 == 0) {
            // 짝수 초: 모든 칸이 폭탄
            char[][] fullBomb = makeFullBombMap();
            printMap(fullBomb);
            return;
        }

        // 폭탄이 설치되고 3초 뒤에 터지기 시작
        char[][] firstBoom = explode(table);
        if ((N - 3) % 4 == 0) {
            printMap(firstBoom);
        } else {
            char[][] secondBoom = explode(firstBoom);
            printMap(secondBoom);
        }
    }

    public static char[][] explode(char[][] map) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        char[][] result = makeFullBombMap();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    result[i][j] = '.';
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            result[nx][ny] = '.';
                        }
                    }
                }
            }
        }

        return result;
    }

    public static char[][] makeFullBombMap() {
        char[][] full = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(full[i], 'O');
        }
        return full;
    }

    public static void printMap(char[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
