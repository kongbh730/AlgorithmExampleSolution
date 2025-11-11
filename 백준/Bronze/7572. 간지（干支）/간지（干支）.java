import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, tenIndex, twelveIndex;

        N = sc.nextInt();
        sc.close();
        
        String ten = "0123456789";
        String twelve = "ABCDEFGHIJKL";

        twelveIndex = (N + 8) % 12;
        tenIndex = (N + 6) % 10;

        System.out.println(twelve.charAt(twelveIndex) + "" + ten.charAt(tenIndex));
    }
}
