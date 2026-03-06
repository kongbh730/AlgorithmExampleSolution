import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int student, apple;
        int i, remainSum = 0;

        for(i = 0; i < N; i++){
            student = sc.nextInt();
            apple = sc.nextInt();
            remainSum += apple % student;
        }

        sc.close();

        System.out.println(remainSum);
    }
}
