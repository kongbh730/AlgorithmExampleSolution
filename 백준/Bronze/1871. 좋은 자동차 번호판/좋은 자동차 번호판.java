import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, j, N;

        N = sc.nextInt();
        for(i = 0; i < N; i++){
            String []num = sc.next().split("-");

            int L = 0, D = 0;

            for(j = 0; j < num[0].length(); j++){
                L += (int) (Math.pow(26, num[0].length() - 1 - j) * (num[0].charAt(j) - 'A'));
            }
            D = Integer.parseInt(num[1]);

            if(Math.abs(L - D) <= 100){
                System.out.println("nice");
            }
            else{
                System.out.println("not nice");
            }
        }

        sc.close();
    }
}
