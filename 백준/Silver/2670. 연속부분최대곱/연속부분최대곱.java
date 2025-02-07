import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static double [] nums;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int N;

        N = sc.nextInt();
        nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
        }
    }

    public static String findAnswer() {
        //System.out.println("findAnswer()");
        int N = nums.length;
        int i;
        double [] DP = new double[N];
        double max = 0.0;
        /*
        * nums 내부 요소들을 곱했을때 최대 값을 구하는 목표다.
        * */

        DP[0] = nums[0];
        for(i = 1; i < N; i++) {
            DP[i] = Math.max(nums[i] ,DP[i - 1] * nums[i]);
            max = Math.max(max, DP[i]);

            //System.out.println(DP[i]);
        }

        return String.format("%.3f", max);
    }
}
