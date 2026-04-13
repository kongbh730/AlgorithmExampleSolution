import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mul = 10, mod;

        while(true){
            //System.out.println(N);
            if(N >= mul){
                mod = N % mul;
                if(mod >= (mul/2)){
                    N = N + (mul - mod);
                }
                else{
                    N = N - mod;
                }
                mul *= 10;
            }
            else{
                break;
            }
        }

        System.out.println(N);
    }
}
