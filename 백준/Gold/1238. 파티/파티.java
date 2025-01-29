import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Node implements Comparable<Node> {
        int destination;
        int cost;

        Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static int N, M, X;
    static ArrayList<Node>[] graph;


    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int i, start, destination, cost;

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        graph = new ArrayList[N + 1];
        for(i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //단방향 그래프
        for (i = 1; i <= M; i++) {
            start = sc.nextInt();
            destination = sc.nextInt();
            cost = sc.nextInt();

            graph[start].add(new Node(destination, cost));
        }

//        System.out.println("\n입력결과");
//        for(i = 1; i <= N; i++) {
//            System.out.print(i + " : ");
//            for(Node node : graph[i]) {
//                System.out.print("(" + node.destination + ", " + node.cost + ") ");
//            }
//            System.out.println();
//        }
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");
        int answer = 0;
        int i;
        int[] toX; // X에서 각 학생으로 가는 최단 거리
        int[] fromX = new int[N + 1];
        // 각 학생이 X로 가는 최단 거리 (toX)와 X에서 각 학생으로 돌아오는 최단 거리 (fromX)를 계산

        toX = dijkstra(X); // 수행하고 나면 각 학생이 X에 가는 최단 거리
        for (i = 1; i <= N; i++) {
            int[] distances = dijkstra(i); // i에서 X로 가는 최단 거리
            fromX[i] = distances[X];
        }

        // 왕복 시간 계산 및 최대값 찾기
        for (i = 1; i <= N; i++) {
            answer = Math.max(answer, fromX[i] + toX[i]);
        }

        return answer;
    }

    // 다익스트라 알고리즘: start에서 모든 노드까지의 최단 거리 계산
    public static int[] dijkstra(int start) {
        //System.out.println("dijkstra(" + start + ")");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리 초기화
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.destination;
            int nowCost = current.cost;

            if (dist[now] < nowCost) continue;

            for (Node neighbor : graph[now]) {
                int next = neighbor.destination;
                int nextCost = nowCost + neighbor.cost;

                if (dist[next] > nextCost) {
                    dist[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }

//        for(int temp : dist){
//            System.out.print(temp + " ");
//        }
//        System.out.println();

        return dist;
    }
}
