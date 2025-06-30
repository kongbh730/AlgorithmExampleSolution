import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;
    static int[] testCase;

    public static void main(String[] args) {
        // 입력
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // DFS 시작 (루트 노드 R에서)
        dfs(R, -1);

        // 쿼리 처리
        for (int i = 0; i < Q; i++) {
            int query = sc.nextInt();
            System.out.println(subtreeSize[query]);
        }

        sc.close();
    }

    static void dfs(int current, int parent) {
        subtreeSize[current] = 1;
        for (int child : tree[current]) {
            if (child != parent) {
                dfs(child, current);
                subtreeSize[current] += subtreeSize[child];
            }
        }
    }
}
