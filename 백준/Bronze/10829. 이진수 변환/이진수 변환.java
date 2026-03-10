import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        sc.close();

        // String bin = Long.toBinaryString(N);
        // System.out.println(bin);

        StringBuilder bin2 = new StringBuilder();
        while(N != 0){
            bin2.append(N % 2);
            N /= 2;
        }
        String reverseBin2 = new StringBuilder(bin2.toString()).reverse().toString();
        System.out.println(reverseBin2);
    }
}
