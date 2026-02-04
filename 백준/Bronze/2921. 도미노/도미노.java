import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        sc.close();

        /*
        * N = 1 : 3 : 0 1 2
        * N = 2 : 12 : 0 1 2 2 3 4
        * N = 3 : 30 : 0 1 2 2 3 3 4 4 5 6
        * N = 4 : 0 0001 0011 0002 0012 0111 1111 0022 0112 1112 0122 1122 0222 2221 2222
        * */

        System.out.println((N * (N + 1) * (N + 2)) / 2);
    }
}
