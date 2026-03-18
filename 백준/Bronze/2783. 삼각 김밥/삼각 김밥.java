import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X, Y;
        int N, i, A, B;
        double min;

        X = sc.nextInt();
        Y = sc.nextInt();
        min = (double) 1000 / Y * X;

        N = sc.nextInt();
        for(i = 0; i < N; i++){
            A = sc.nextInt();
            B = sc.nextInt();
            if((double) 1000 / B * A < min){
                min = (double) 1000 / B * A;
            }
        }

        sc.close();

        System.out.printf("%.2f\n", min);
    }
}
