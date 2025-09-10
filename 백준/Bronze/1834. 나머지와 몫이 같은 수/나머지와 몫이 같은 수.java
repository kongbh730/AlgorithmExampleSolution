import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, i;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long answer = 0;

        // N = 3 : 4, 8
        // N = 4 : 5, 10, 15
        // N = 5 : 6, 12, 18, 24
        for(i = 1; i < N; i++){
            answer += ((long) (N + 1) * i);
        }


        System.out.println(answer);
    }
}
