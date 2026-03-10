import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i;

        for(i = 0; i < N; i++){
            double price = sc.nextDouble();
            System.out.printf("$%.2f%n",(price * 0.8));
        }

        sc.close();
    }
}
