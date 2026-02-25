import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, a, b, gcd, lcm;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            gcd = findGcd(a, b);
            lcm = findLcm(a, b, gcd);

            System.out.println(lcm + " " + gcd);
        }
    }

    public static int findGcd(int a, int b){
        int temp;

        if(a > b){
            temp = b;
            b = a;
            a = temp;
        }

        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static int findLcm(int a, int b, int gcd){
        return a / gcd * b;
    }
}
