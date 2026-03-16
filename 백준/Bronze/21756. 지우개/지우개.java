import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++){
            arr[i] = i;
        }

        int len = N; 

        while (len > 1) {
            int idx = 1;
            
            for (int i = 2; i <= len; i += 2) { 
                arr[idx++] = arr[i];
            }
            len = idx - 1;
        }

        System.out.println(arr[1]);
    }
}