import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, L, i = 1, count = 0;
        int [] receiveCount;

        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        receiveCount = new int[N + 1];
        Arrays.fill(receiveCount, 0);

        while(true){
            receiveCount[i]++;
            if(receiveCount[i] == M){
                break;
            }
            if(receiveCount[i] % 2 == 0){//짝수
                i = i - L;
                if(i <= 0){
                    i = N + i;
                }
            }
            else{//홀수
                i = i + L;
                if (i > N) {
                    i = i - N;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
