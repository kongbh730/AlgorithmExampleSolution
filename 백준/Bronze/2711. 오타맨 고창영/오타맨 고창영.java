import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, T, err;
        String str;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            err = sc.nextInt();
            str = sc.next();

            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(err - 1);

            System.out.println(sb.toString());
        }
        
        sc.close();
    }
}
