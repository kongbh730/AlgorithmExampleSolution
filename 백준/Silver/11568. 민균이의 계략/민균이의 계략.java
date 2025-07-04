import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [] cards;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        cards = new int[N];
        for(i = 0; i < N; i++){
            cards[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int findAnswer(){
        int answer = 1;
        int [] DP = new int[N];
        int i, j;

        //LIS최장 증가 부분 수열를 구하는 문제?
        Arrays.fill(DP, 1);// 모든 최소길이는 1
        for (i = 0; i < N; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (cards[i] > cards[j])
                {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                    if (answer < DP[i])
                    {
                        answer = DP[i];
                    }
                }
            }
        }

        return answer;
    }
}
