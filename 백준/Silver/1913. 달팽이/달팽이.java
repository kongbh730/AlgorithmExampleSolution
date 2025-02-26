import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();

        findAnswer(N, M);
    }

    public static void findAnswer(int N, int M) {
        int i = 0, j = 0, K = N * N, row = 0, col = 0;
        int [][] square = new int[N][N];
        int direction = 0;

        while(K != 0){
            square[i][j] = K;

            if(direction == 0){ //아래로
                if(i + 1 >= N || square[i + 1][j] != 0){
                    direction = (direction + 1) % 4;//오른쪽으로 방향 전환
                    j += 1;
                }
                else{
                    i += 1;
                }
            }
            else if(direction == 1){// 오른쪽으로
                if(j + 1 >= N || square[i][j + 1] != 0){
                    direction = (direction + 1) % 4;//위쪽으로 방향 전환
                    i -= 1;
                }
                else{
                    j += 1;
                }
            }
            else if(direction == 2){// 위로
                if(i - 1 < 0 || square[i - 1][j] != 0){
                    direction = (direction + 1) % 4;//왼쪽으로 방향 전환
                    j -= 1;
                }
                else{
                    i -= 1;
                }
            }
            else if(direction == 3){ // 왼쪽으로
                if(j - 1 < 0 || square[i][j - 1] != 0){
                    direction = 0;//아래쪽으로 방향 전환
                    i += 1;
                }
                else{
                    j -= 1;
                }
            }

            K--;
        }

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                System.out.print(square[i][j] + " ");
                if(square[i][j] == M){
                    row = i + 1;
                    col = j + 1;
                }
            }
            System.out.println();
        }
        System.out.println(row + " " + col);
    }
}
