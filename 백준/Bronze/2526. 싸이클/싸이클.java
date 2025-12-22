import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, P;

        N = sc.nextInt();
        P = sc.nextInt();
        sc.close();

        int current = N;
        int next = (current * current) % P;

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(current);
        while (!lists.contains(next)) {
            //System.out.println("next : " + next);
            //System.out.println(lists.indexOf(next));
            lists.add(next);
            next = (next * N) % P;
        }

        //System.out.println("next : " + next);
        //System.out.println(lists.indexOf(next));
        System.out.println(lists.size() - lists.indexOf(next));
    }
}
