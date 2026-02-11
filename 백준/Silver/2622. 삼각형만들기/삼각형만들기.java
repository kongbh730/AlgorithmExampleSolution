import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.close();

        //1: 0
        //2: 0
        //3: 1
        //4: 0
        //5: 1
        //6: 2
        //7: 133, 322: 2
        //8: 233: 1
        //9: 333, 432, 144: 3

        int count = 0;
        int i, j, k;
        
        for(i = 1; i <= (N / 3); i++){
            for(j = i; j <= ((N - i)/2); j++){
                k = N - i - j;
                
                if(k < i + j){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
