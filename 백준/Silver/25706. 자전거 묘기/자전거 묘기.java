import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [] road;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        road = new int[N];
        for(i = 0; i < road.length; i++){
            road[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer(){
        int [] DP = new int[road.length];
        int i, next;

        for (i = N - 1; i >= 0; i--) {
            if (road[i] == 0) {
                next = i + 1;
            } else {
                next = i + road[i] + 1;
            }

            if (next >= N) {
                DP[i] = 1;
            } else {
                DP[i] = 1 + DP[next];
            }
        }

        for(int num : DP){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
