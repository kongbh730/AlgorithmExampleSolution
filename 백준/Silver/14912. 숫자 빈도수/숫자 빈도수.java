import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, d, j;
        int [] digit = new int[10];
        String temp;

        n = sc.nextInt();
        d = sc.nextInt();
        for(i = 1; i <= n; i++){
            temp = String.valueOf(i);
            for(j = 0; j < temp.length(); j++){
                digit[temp.charAt(j) - '0']++;
            }
        }
//        for(i = 0; i < 10; i++){
//            System.out.println(i + " : " + digit[i]);
//        }
        System.out.println(digit[d]);
    }
}
