import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        int [] K;
        int i, j, sum = 0;

        N = sc.nextInt();
        M = sc.nextInt();
        K = new int[M];
        for(i = 0; i < M; i++){
            K[i] = sc.nextInt();
        }
        sc.close();

        /*
        * 10 2
            2 3
        * 2 3 4 6 8 9 10
        * */

        for(i = 1; i <= N; i++){
            for(j = 0; j < M; j++){
                if(i % K[j] == 0){
                    //System.out.println("i : " + i);
                    sum += i;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
