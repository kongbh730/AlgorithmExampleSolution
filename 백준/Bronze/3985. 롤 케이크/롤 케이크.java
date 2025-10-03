import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, N;
    static int[][] arr;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        L = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][2];
        for(i = 0; i < arr.length; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, expectMax = 0, realMax = 0, left, right, j, expectMaxOne = 0, relaMaxOne = 0, sum;
        boolean []cake = new boolean[L + 1];

        Arrays.fill(cake, false);
        for(i = 0; i < arr.length; i++){
            left = arr[i][0];
            right = arr[i][1];
            sum = 0;

            for(j = left; j <= right; j++){
                if(!cake[j]){
                    cake[j] = true;
                    sum++;
                }
            }
            if(sum > realMax){
                realMax = sum;
                relaMaxOne = i + 1;
            }

            if(right - left > expectMax){
                expectMax = right - left;
                expectMaxOne = i + 1;
            }
        }

        System.out.println(expectMaxOne);
        System.out.println(relaMaxOne);
    }
}
