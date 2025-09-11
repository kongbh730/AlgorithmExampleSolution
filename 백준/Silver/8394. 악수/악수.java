import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n = 2 : 2 .., - : 2
        //n = 3 : 3 ..., -., .- : 3
        //n = 4 : 5 ...., -.., .-., ..-, -- : 5
        //n = 5 : - ... * 4 + --. * 3 + ..... * 1 : 8
        //n = 6 : ...... * 1 + -.... * 5 + --.. * 6 + --- * 1 = 13

        //피보나치임
        int i;
        int [] fibonacci = new int [n + 1];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for(i = 2; i <= n; i++){
            fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1]) % 10;
        }

        System.out.println(fibonacci[n]);
    }
}
