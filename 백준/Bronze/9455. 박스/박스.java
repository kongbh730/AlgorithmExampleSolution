import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n;
    static int [][] grid;

    public static void main(String[] args) {
        int i;
        int T = sc.nextInt();
        for(i = 0; i < T; i++){
            inputData();
            System.out.println(findAnswer());
        }

        sc.close();
    }

    public static void inputData(){
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new int[m][n];
        int i, j;

        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public static int findAnswer() {
        int answer = 0;
        int i, j;
        int empty;

        for (j = 0; j < n; j++) {
            empty = 0;
            for (i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    empty++;
                } else { // grid[i][j] == 1
                    answer += empty;
                }
            }
        }
        return answer;
    }

}
