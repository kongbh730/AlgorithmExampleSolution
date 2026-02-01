import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, N = sc.nextInt();
        long sum = 1L;

        for(i = 2; i <= N; i++){
            sum *= i;
            //System.out.println(sum);
        }
        System.out.println(sum / (7 * 24 * 60 * 60));

        sc.close();
    }
}
