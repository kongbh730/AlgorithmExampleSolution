import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int R, C, W;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        R = sc.nextInt();
        C = sc.nextInt();
        W = sc.nextInt();

        sc.close();
    }

    public static int findAnswer(){
        int i, j;
        int sum = 0;

        int [][]DP = new int[31][31];
        /*
        * 0 0
        * 0 1 0
        * 0 1 1 0
        * 0 1 2 1 0
        * 0 1 3 3 1 0
        * 0 1 4 6 4 1 0
        * ........
        * */
        DP[0][0] = 0;
        DP[0][1] = 0;
        DP[1][0] = 0;
        DP[1][1] = 1;
        DP[1][2] = 0;

        for(i = 2; i <= 30; i++){
            for(j = 1; j <= i; j++){
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
            }
        }

//        for(i = 0; i <= 30; i++){
//            for(j = 0; j <= 30; j++){
//                System.out.print(DP[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(i = 0; i < W; i++){
            for(j = 0; j <= i; j++){
                sum += DP[R + i][C + j];
                //System.out.print(DP[R + i][C + j] + " ");
            }
            //System.out.println();
        }

        return sum;
    }
}
