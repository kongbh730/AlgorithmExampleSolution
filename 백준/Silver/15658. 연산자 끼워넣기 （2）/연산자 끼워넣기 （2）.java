import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] A;
    static int [] operator = new int[4];
    static int N;
    static int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        A = new int[N];
        for(i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        for(i = 0; i < operator.length; i++){
            operator[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer(){
        DFS(1, A[0]);
        System.out.println(maxSum);
        System.out.println(minSum);
    }

    public static void DFS(int depth, int sum) {
        if (depth == N) { 
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--; // 사용
                switch (i) {
                    case 0: DFS(depth + 1, sum + A[depth]); break;
                    case 1: DFS(depth + 1, sum - A[depth]); break;
                    case 2: DFS(depth + 1, sum * A[depth]); break;
                    case 3:
                        if (sum < 0) {
                            DFS(depth + 1, -(-sum / A[depth]));
                        } else {
                            DFS(depth + 1, sum / A[depth]);
                        }
                        break;
                }
                operator[i]++; // 복구 (백트래킹)
            }
        }
    }
}
