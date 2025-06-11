import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String A, B;

        A = sc.next();
        B = sc.next();

        int i, j;
        long sum = 0;

        for(i = 0; i < A.length(); i++){
            for(j = 0; j < B.length(); j++){
                sum += (long)(A.charAt(i) - '0') * (B.charAt(j) - '0');
            }
        }
        System.out.println(sum);

        sc.close();
    }
}
