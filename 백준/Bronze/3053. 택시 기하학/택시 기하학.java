import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R;
        double PI = 3.14159265358979323846, S;

        R = sc.nextInt();

        //유클리드 기하학에서 원의 넓이 : S = R^2 * PI
        S = R * R * PI;
        System.out.printf("%.6f\n", S);

        //택시기하학에서 원의 넓이 : S = R^2 * 2
        S = R * R * 2;
        System.out.printf("%.6f\n", S);

        sc.close();
    }
}
