import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;
    static int[] query;

    public static void main(String[] args) {
        inputData();
        findAnswer();

        sc.close();
    }

    public static void inputData(){
        int i, u, v;

        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];
        query = new int[Q];

        for (i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (i = 0; i < N - 1; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        for(i = 0; i < Q; i++){
            query[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void dfs(int current, int parent) {
        subtreeSize[current] = 1;
        for (int child : tree[current]) {
            if (child != parent) {
                dfs(child, current);
                subtreeSize[current] += subtreeSize[child];
            }
        }
    }

    public static void dfsIterative(int root) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();
        boolean[] visited = new boolean[N + 1];

        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            postOrder.push(curr); // 후위 순회를 위한 스택

            for (int child : tree[curr]) {
                if (!visited[child]) {
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }

        // 후위 순회 결과를 바탕으로 서브트리 크기 계산
        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            subtreeSize[node] = 1; // 자기 자신 포함
            for (int child : tree[node]) {
                if (subtreeSize[child] > 0) { // 이미 계산된 서브트리만 합산
                    subtreeSize[node] += subtreeSize[child];
                }
            }
        }
    }


    public static void findAnswer(){
        int i;

        // DFS 시작 (루트 노드 R에서)
        dfs(R, -1);
        //dfsIterative(R);

        // 쿼리 처리
        for (i = 0; i < Q; i++) {
            System.out.println(subtreeSize[query[i]]);
        }
    }
}
