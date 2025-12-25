import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();
        
        //System.out.println(str.charAt(0));
        System.out.println((int)str.charAt(0) - '가' + 1);
    }
}
