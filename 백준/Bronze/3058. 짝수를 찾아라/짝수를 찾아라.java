import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int T, i, j, temp, min, sum;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            min = 101;
            sum = 0;

            for(j = 0; j < 7; j++){
                temp = sc.nextInt();
                if(temp % 2 == 0){
                    sum += temp;
                    if(temp < min){
                        min = temp;
                    }
                }
            }

            System.out.println(sum + " " + min);
        }

        sc.close();
    }
}
