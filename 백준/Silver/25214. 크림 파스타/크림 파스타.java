import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [] A;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i, N;

        N = sc.nextInt();
        A = new int[N];
        for(i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer() {
        int[] max = new int[A.length];
        int diff, j, min = A[0];
        
        max[0] = 0;

        for (j = 1; j < A.length; j++) {
            diff = A[j] - min;
            max[j] = Math.max(max[j - 1], diff);
            min = Math.min(min, A[j]);
        }

        for (int val : max) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
