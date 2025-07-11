import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = N; i >= 1; i--) {
            dq.addFirst(i);
            
            for (int j = 0; j < i; j++) {
                dq.addFirst(dq.pollLast());
            }
        }

        for (int num : dq) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
