import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static ArrayList<Node>[] graph; //Arraylist 배열

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int i, A_i, B_i, C_i;

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for(i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(i = 0; i < M; i++) {
            A_i = sc.nextInt();
            B_i = sc.nextInt();
            C_i = sc.nextInt();

            //양방향 그래프, 길이 여러개 있을 수도 있음
            graph[A_i].add(new Node(B_i, C_i));
            graph[B_i].add(new Node(A_i, C_i));
        }

//        System.out.println("입력결과");
//        for(i = 1; i <= N; i++) {
//            System.out.print(i + " ");
//            for(int j = 0; j < graph[i].size(); j++) {
//                System.out.print("(" + graph[i].get(j).destination + ", " + graph[i].get(j).cost + ") ");
//            }
//            System.out.println();
//        }
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");

        int i, j;
        boolean [] visited = new boolean[N + 1];
        int [] distance = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);//초기화
        distance[1] = 0;//시작은 1
        pq.offer(new Node(1, 0));

        //다익스트라 수행
        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(!visited[current.destination]) {//방문한 적 없다면
                visited[current.destination] = true;
            }
            else{//이미 방문했었다면
                continue;
            }

            for(i = 0; i < graph[current.destination].size(); i++) {
                Node next = graph[current.destination].get(i);
                if (distance[next.destination] > distance[current.destination] + next.cost) {
                    distance[next.destination] = distance[current.destination] + next.cost;
                    pq.offer(new Node(next.destination, distance[next.destination]));
                }
            }

//            for(int temp : distance) {
//                System.out.print(temp + " ");
//            }
//            System.out.println();
        }

        return distance[N];
    }

    //Comparable 인터페이스 사용
    static class Node implements Comparable<Node> {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
