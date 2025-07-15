import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] arr;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int N, i;

        N = sc.nextInt();
        arr = new int[N];
        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int findAnswer() {
        int max = 1, inc = 1, dec = 1;
        int i;

        for (i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]){
                inc++;
            }
            else {
                inc = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                dec++;
            }
            else {
                dec = 1;
            }

            max = Math.max(max, Math.max(inc, dec));
        }

        return max;
    }
}
