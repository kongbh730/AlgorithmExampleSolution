import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[] apple;
    static List<Integer>[] tree;

    public static void main(String[] args) {
        inputData();
        System.out.println(dfs(0, 0));
    }

    public static void inputData() {
        int i, parent, child;

        n = sc.nextInt(); //정점
        k = sc.nextInt(); //거리

        tree = new ArrayList[n];
        for (i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (i = 0; i < n - 1; i++) {
            parent = sc.nextInt();
            child = sc.nextInt();
            tree[parent].add(child);
        }

        apple = new int[n];
        for (i = 0; i < n; i++) {
            apple[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int dfs(int node, int depth) {
        if (depth > k){
            return 0;
        }

        int sum = apple[node];

        for (int next : tree[node]) {
            sum += dfs(next, depth + 1);
        }
        return sum;
    }
}
