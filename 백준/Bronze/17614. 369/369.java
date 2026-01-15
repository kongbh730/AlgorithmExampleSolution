import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i, j, count = 0;

        for(i = 1; i <= N; i++){
            String num = String.valueOf(i);
            for(j = 0; j < num.length(); j++){
                if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9'){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
