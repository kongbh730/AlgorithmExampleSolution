import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, T, N;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            N = sc.nextInt();
            System.out.println(findAnswer(N));
        }
    }

    public static int findAnswer(int N){
        int answer = 0;

        while (N >= 5) {
            answer += N / 5;
            N /= 5;
        }

        return answer;
    }
}
