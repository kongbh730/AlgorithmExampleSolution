import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S1, S2, S3;

        S1 = sc.nextInt();
        S2 = sc.nextInt();
        S3 = sc.nextInt();
        sc.close();

        int [] sum = new int[S1 + S2 + S3 + 1];
        int i, j, k;

        for(i = 1; i <= S1; i++){
            for(j = 1; j <= S2; j++){
                for(k = 1; k <= S3; k++){
                    sum[i + j + k]++;
                }
            }
        }

        int max = 0, index = 0;
        for(i = 0; i < sum.length; i++){
            if(sum[i] > max){
                max = sum[i];
                index = i;
            }
        }

        System.out.println(index);
    }
}
