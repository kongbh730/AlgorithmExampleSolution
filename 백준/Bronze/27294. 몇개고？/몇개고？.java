import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, S;
        T = sc.nextInt();
        S = sc.nextInt();
        sc.close();
        if(T >= 12 && T <= 16 && S == 0){
            System.out.println(320);
        }
        else{
            System.out.println(280);
        }
    }
}
