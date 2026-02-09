import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i;
        int [] p = new int[N + 1];

        //p[1] = 1/2;
        //p[2] = 2/3;
        //p[3] = 3/5;
        //p[4] = 5/8;....

        p[0] = 1;
        p[1] = 2;
        for(i = 2; i < N; i++){
            p[i] = p[i-1] + p[i-2];
            //System.out.println(p[i]);
        }
        System.out.println(p[N-1]);
    }
}
