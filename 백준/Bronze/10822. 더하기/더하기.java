import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;

        s = sc.next();
        sc.close();
        String [] str = s.split(",");
        int sum = 0;
        for (String string : str) {
            sum += Integer.parseInt(string);
        }
        System.out.println(sum);
    }
}
