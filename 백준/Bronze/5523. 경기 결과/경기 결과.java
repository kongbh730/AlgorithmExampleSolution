import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, A = 0, B = 0, a, b;

        N = sc.nextInt();
        for(int i = 0; i < N; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            if(a > b){
                A++;
            }
            else if(a < b){
                B++;
            }
        }

        sc.close();
        System.out.println(A + " " + B);
    }
}
