import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String n;
        int i, sum = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.next();
        sc.close();
        for(i = 0; i < n.length(); i++){
            sum += (int) Math.pow(n.charAt(i) - '0',5);
        }

        System.out.println(sum);
    }
}
