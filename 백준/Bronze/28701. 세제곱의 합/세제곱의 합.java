import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i, sum = 0;

        sc.close();
        for(i = 1; i <= N; i++){
            sum += i;
        }
        System.out.println(sum);
        System.out.println((int)Math.pow(sum, 2));
        System.out.println((int)Math.pow(sum, 2));
    }
}
