import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [][]draw = new int[101][101];
    static int N, M;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        int i, j, k, leftX, leftY, rightX, rightY;

        N = sc.nextInt();
        M = sc.nextInt();
        for(i = 0; i < N; i++) {
            leftX = sc.nextInt();
            leftY = sc.nextInt();
            rightX = sc.nextInt();
            rightY = sc.nextInt();
            for(j = leftY; j <= rightY; j++) {
                for(k = leftX; k <= rightX; k++) {
                    draw[j][k]++;
                }
            }
        }
    }

    public static int findAnswer() {
        int i, j, count = 0;

        for(i = 0; i < 101; i++) {
            for(j = 0; j < 101; j++) {
                if(draw[i][j] > M) {
                    count++;
                }
            }
        }

        return count;
    }
}
