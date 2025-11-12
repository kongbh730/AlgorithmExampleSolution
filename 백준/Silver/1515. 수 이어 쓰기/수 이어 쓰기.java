import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N;
        int i, minimum = 0;
        int idx = 0;

        N = sc.next();
        sc.close();

        while (idx < N.length()) {
            minimum++;
            String num = Integer.toString(minimum);
            for (i = 0; i < num.length() && idx < N.length(); i++) {
                if (num.charAt(i) == N.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(minimum);
    }
}
