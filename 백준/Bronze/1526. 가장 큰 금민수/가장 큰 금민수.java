import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        System.out.println(findAnswer(N));
    }

    public static int findAnswer(int N){
        for(int i = N; i >= 4; i--){
            String s = String.valueOf(i);
            boolean flag = true;

            for(char c : s.toCharArray()){
                if(c != '4' && c != '7'){
                    flag = false;
                    break;
                }
            }

            if(flag){
                return i;
            }
        }

        return 4;
    }
}
