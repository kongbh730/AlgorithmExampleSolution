import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first, second, third;

        third = sc.nextInt();
        second = sc.nextInt();
        first = second + (second - third);
        System.out.println(first);

        sc.close();
    }
}
