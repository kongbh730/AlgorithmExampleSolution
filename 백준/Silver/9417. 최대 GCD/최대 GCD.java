import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N, i;

        N = sc.nextInt();
        sc.nextLine();// 개행 문자
        for(i = 0; i < N; i++){
            String [] testCase = sc.nextLine().split(" ");
            int[] nums = new int[testCase.length];

            for (int j = 0; j < testCase.length; j++) {
                nums[j] = Integer.parseInt(testCase[j]); // 각 토큰을 정수로 변환
            }
            System.out.println(findAnswer(nums));
        }

        sc.close();
    }

    public static int findAnswer(int [] nums){
        int i, j, A, B, maxGCD = 1;

        for(i = 0; i < nums.length - 1; i++){
            for(j = i + 1; j < nums.length; j++){
                A = nums[i];
                B = nums[j];
                if(A < B){
                    int temp = A;
                    A = B;
                    B = temp;
                }

                while(B != 0){
                    int temp = A % B;
                    A = B;
                    B = temp;
                }

                if(maxGCD < A){
                    maxGCD = A;
                }
            }
        }

        return maxGCD;
    }
}
