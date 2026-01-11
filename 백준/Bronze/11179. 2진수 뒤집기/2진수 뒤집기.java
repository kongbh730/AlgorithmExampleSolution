import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, reverseN;
        String binary, reverseBinary;

        N = sc.nextInt();
        sc.close();

        binary = Integer.toBinaryString(N);
        reverseBinary = new StringBuilder(binary).reverse().toString();
        reverseN = Integer.parseInt(reverseBinary, 2);

        System.out.println(reverseN);
    }
}
