import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M, K; // N : 그래프 정점의 개수, M : 그래프 간선의 개수, K : 턴의 수
    static ArrayList<int []> graph;

    public static void main(String[] args) {
        inputData();
        findAnswer();

        sc.close();
    }

    public static void inputData() {
        int i;
        graph = new ArrayList<>();
        int x, y;

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        for(i = 1; i <= M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph.add(new int [] {x, y, i});
        }
    }

    public static void findAnswer() {
        int i, turn;

        for (turn = 0; turn < K; turn++) {
            int[] parent = new int[N + 1];

            for (i = 1; i <= N; i++) {
                parent[i] = i;
            }

            int totalCost = 0;
            int edgeCount = 0;

            // turn 번째 간선부터 시작
            for (i = turn; i < graph.size(); i++) {
                int[] edge = graph.get(i);
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (union(u, v, parent)) {
                    totalCost += w;
                    edgeCount++;
                    if (edgeCount == N - 1) {
                        break;
                    }
                }
            }

            // MST 완성 안되면 0 출력
            if (edgeCount == N - 1) {
                System.out.print(totalCost + " ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    public static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    public static boolean union(int a, int b, int[] parent) {
        int pa, pb;

        pa = find(a, parent);
        pb = find(b, parent);
        if (pa == pb) {
            return false;
        }
        parent[pb] = pa;

        return true;
    }
}
