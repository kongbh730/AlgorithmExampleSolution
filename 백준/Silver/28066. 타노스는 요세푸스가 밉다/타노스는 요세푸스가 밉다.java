import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int N, K;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        N = sc.nextInt();
        K = sc.nextInt();
        for (i = 1; i <= N; i++) {
            dq.add(i);
        }

        sc.close();
    }

    public static int findAnswer(){
        int answer = 0, i;
        //시간 단축을 많이 해야 함

        while (dq.size() > 1) {
            int first = dq.pollFirst();
            for (i = 0; i < K - 1 && !dq.isEmpty(); i++) {
                dq.pollFirst();
            }
            dq.addLast(first);
        }

        return dq.peek();
    }
}
