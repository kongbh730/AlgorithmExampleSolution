import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K, i, j, A, B;

        N = sc.nextInt();
        K = sc.nextInt();
        String [] str = sc.next().split(",");
        sc.close();

        int[] arr = new int[N];
        for (i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        for (i = 0; i < K; i++) {
            int[] nextArr = new int[arr.length - 1];

            for (j = 0; j < nextArr.length; j++) {
                nextArr[j] = arr[j + 1] - arr[j];
            }
            arr = nextArr;
        }

        for(i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]);
    }
}
