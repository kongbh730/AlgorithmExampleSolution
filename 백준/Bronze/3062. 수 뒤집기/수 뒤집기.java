import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, N, reverseN, sum, j;

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            N = sc.nextInt();
            reverseN = Integer.parseInt(new StringBuilder(String.valueOf(N)).reverse().toString());

            sum = N + reverseN;
            String SUM = String.valueOf(sum);

            boolean flag = true;
            for(j = 0; j < SUM.length()/2; j++){
                if(SUM.charAt(j) != SUM.charAt(SUM.length() - 1 - j)){
                    flag = false;
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

        sc.close();
    }
}
