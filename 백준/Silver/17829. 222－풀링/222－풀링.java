import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static short [][] map;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int N, i, j;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new short[N][N];
        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                map[i][j] = (short) sc.nextInt();
            }
        }

        sc.close();
    }

    public static int findAnswer(){
        short [][] A = map;
        short [][] B;
        int i, j;

        while(true){
            B = new short[A.length/2][A.length/2];
            for(i = 0; i < A.length; i += 2){
                for(j = 0; j < A.length; j += 2){
                    short [] temp = {A[i][j], A[i+1][j], A[i][j+1], A[i+1][j+1]};
                    Arrays.sort(temp);
                    B[i/2][j/2] = temp[2];
                }
            }
            A = B;
            if(A.length == 1){
                break;
            }
        }

        return A[0][0];
    }
}
