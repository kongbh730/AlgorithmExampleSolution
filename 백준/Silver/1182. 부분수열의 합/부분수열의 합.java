import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, S, i, count = 0, sum, mask;

        N = sc.nextInt();
        S = sc.nextInt();
        int [] arr = new int[N];

        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        for (mask = 1; mask < (1 << N); mask++) {
            sum = 0;
            for (i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0){
                    sum += arr[i];
                }
            }

            if (sum == S){
                count++;
            }
        }

        System.out.println(count);
    }
}
