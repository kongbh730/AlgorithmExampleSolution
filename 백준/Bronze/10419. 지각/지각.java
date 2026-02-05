import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, d, i, t;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            d = sc.nextInt();//수업시간

            for(t = 0; (t * t) + t <= d; t++){
                
            }
            System.out.println(t - 1);
        }
    }
}
