import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, B, A, count = 0;

        N = sc.nextInt();
        sc.close();

        for(B = 1; B <= 500; B++){
            for(A = 1; A<= 500; A++){

                if(B * B + N == A * A){
                    //System.out.println(B);
                    //System.out.println(A);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
