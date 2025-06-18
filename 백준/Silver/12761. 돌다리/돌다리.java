import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int A, B, N, M;

    //최소한의 이동횟수니까. 최단거리? -> DFS?, DP?
    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData(){
        A = sc.nextInt();
        B = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
    }

    public static int findAnswer(){
        //최소이동횟수니까, DFS로 풀 수 있지만, 방향이 (+1, -1, +A, -A, +B, -B, *A, *B)까지 8개니까
        //큐가 너무 커질 거 같음.
        //DP로? -> 근데 DP로 하면 0부터 시작이라 범위 지정이 어려움...

        //만약 N과 M이 같다면?
        if(N == M){
            return 0;
        }

        Queue <Integer> q = new LinkedList<>();
        int current, next, i, j, count = 0, q_size;
        boolean [] visited = new boolean[100001];
        int [] branches = {1, -1, A, -A, B, -B, 0, 0};

        q.offer(N);
        visited[N] = true;
        while(!q.isEmpty()){

            q_size = q.size();
            for(j = 0; j < q_size; j++){
                current = q.poll();
                for(i = 0; i < branches.length; i++){
                    if(i == 6){
                        next = current * A;
                    }
                    else if(i == 7){
                        next = current * B;
                    }
                    else{
                        next = current + branches[i];
                    }

                    if(next >= 0 && next <= 100000 && !visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }

                    if(visited[M]){
                        return count + 1;
                    }
                }
            }
            count++;
        }

        return count;
    }
}
