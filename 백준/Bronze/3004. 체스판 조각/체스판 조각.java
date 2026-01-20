import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N, A, B;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        /*
        1 -> 2
        2 -> 4
        3 -> 6
        4 -> 9
        5 -> 12
        6 -> 16
        7 -> 20
        */

        A = (N / 2) + 1;
        B = (N - A + 1) + 1;
      
        System.out.println(A * B);
    }
}
