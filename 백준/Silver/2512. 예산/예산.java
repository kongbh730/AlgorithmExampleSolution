import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int [] provinces;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        N = sc.nextInt();//지방 수
        provinces = new int[N];
        for(i = 0; i < N; i++){
            provinces[i] = sc.nextInt();
        }
        M = sc.nextInt();//국가 예산

        sc.close();
    }

    public static int findAnswer(){
        int max = 0;
        long sum = 0;
        int left, right, answer;

        for (int x : provinces) {
            max = Math.max(max, x);
            sum += x;
        }
        if (sum <= M) {
            return max;
        }

        left = 0;
        right = max;
        answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long total = 0;

            for (int x : provinces) {
                total += (Math.min(x, mid));
                if (total > M){
                    break;
                }
            }

            if (total <= M) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
