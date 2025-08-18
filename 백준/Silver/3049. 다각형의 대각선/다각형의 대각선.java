import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();

        /*
        * N = 3 : (0 * 3)
        * N = 4 : (1 * 4 - 4) + 1 = 1
        * N = 5 : (2 * 5 - 5) + 0 = 5
        * N = 6 : (3 * 6 - 6) + 3 = 15
        * N = 7 : (4 * 7 - 7) + (3 * 7 - 7) = 35
        *
        * 두 대각선이 교차하려면 점이 4개 필요함
        * N개의 점 중 4개를 고르는 경우
        * */

        System.out.println((N)*(N - 1)*(N-2)*(N-3) / 24);
    }
}
