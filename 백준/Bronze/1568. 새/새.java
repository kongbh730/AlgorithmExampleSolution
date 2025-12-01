import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = 1, time = 0;

        while(N != 0){
            if(K > N){
                K = 1;
            }
            else{//K <= N
                N = N - K;
                K++;
                time++;
            }
        }

        System.out.println(time);
    }
}
