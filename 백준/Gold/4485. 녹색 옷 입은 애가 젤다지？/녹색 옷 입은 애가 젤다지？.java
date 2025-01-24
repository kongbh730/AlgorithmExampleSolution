import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [][] caveMap;

    //Node 객체가 Comparable 인터페이스를 구현함
    /*
    * Comparable 인터페이스
    * 클래스가 기본 정렬 방식을 제공하도록 강제
    * 클래스에 정렬 기준 정의하기 위해 구현
    * 정렬 기준이 고정적이고 한가지 방식일 경우 사용
    */
    static class Node implements Comparable<Node> {
        int x; //x좌표
        int y; //y좌표
        int cost; //루피 크기

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        //priorityQueue의 경우 compareTo로 정렬을 함. 이때 Node 클래스에 compareTo 정렬 기준을 내장해서 정렬 수행
        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String []args){
        int i = 1;

        while(true){
            N = sc.nextInt();
            if(N == 0){
                break;
            }
            inputData();
            System.out.println("Problem " + i + ": " + findAnswer());
            i++;
        }

        sc.close();
    }

    public static void inputData(){
        //System.out.println("inputData()");
        int i, j, k;

        caveMap = new int[N][N];//매 테스트 케이스마다 초기화
        //동굴 각 칸에 있는 도둑루피의 크기 k: 이 칸을 지나면 k개의 루피를 잃음
        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                k = sc.nextInt();
                caveMap[i][j] = k;
            }
        }
    }

    public static int findAnswer(){
        //System.out.println("\nfindAnswer()");
        int answer = -1;
        int[][] distance = new int[N][N];//거리 배열 == 지나온 비용 기입
        int [][] direction = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        int i, nextX, nextY, nextCost;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        //거리 배열 전부 최대 값으로 초기화
        for(i = 0; i < distance.length; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = caveMap[0][0];//시작 위치 값 저장
        pq.offer(new Node(0, 0, distance[0][0]));//add는 실패시 예외처리, offer는 실패시 false 반환
        //pq에 node를 삽입하는데 cost가 작은 순으로 오름차순 정렬됨

        while(!pq.isEmpty()){
            Node node = pq.poll();// 비용이 가장 작은 노드 꺼냄
            //System.out.println("\ncurrent node : " + node.x + ", " + node.y + ", " + node.cost);

            if(node.x == N - 1 && node.y == N - 1){//도착
//                for(i = 0; i < distance.length; i++){
//                    for(int temp : distance[i]){
//                        System.out.print(temp + " ");
//                    }
//                    System.out.println();
//                }
                return node.cost;
            }

            if(node.cost > distance[node.y][node.x]){//현재 노드 비용이 이미 갱신된 거리보다 크면 무시
                continue;
            }

            for(i = 0; i < direction.length; i++){
                nextX = node.x + direction[i][0];
                nextY = node.y + direction[i][1];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                    nextCost = node.cost + caveMap[nextY][nextX];
                    //System.out.println("next node : " + nextX + ", " + nextY + ", " + nextCost);
                    if(nextCost < distance[nextY][nextX]){
                        distance[nextY][nextX] = nextCost;
                        pq.offer(new Node(nextX, nextY, nextCost));
                    }
                }
            }
        }

        return answer;
    }
}
