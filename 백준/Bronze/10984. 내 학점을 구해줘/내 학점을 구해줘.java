import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T, i, j, N;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            N = sc.nextInt();
            double GPA;
            double sum = 0;
            int total = 0;

            for(j = 0; j < N; j++){
                int C = sc.nextInt();
                double G = sc.nextDouble();
                total += C;
                sum += C * G;  // 가중합
            }

            GPA = sum / total;
            System.out.printf("%d %.1f\n", total, GPA);
        }

        sc.close();
    }
}
