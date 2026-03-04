import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N;

        N = sc.next();
        int A, B;
        int i, j;
        boolean flag = false;

        for(i = 1; i < N.length(); i++){
            A = 1;
            B = 1;

            //A의 자리수의 곱
            for(j = 0; j < i; j++){
                A *= N.charAt(j) - '0';
            }

            //B의 자리수의 곱
            for(j = i; j < N.length(); j++){
                B *= (int)N.charAt(j) - '0';
            }

            //비교
            //System.out.println(A);
            //System.out.println(B);
            if(A == B){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
