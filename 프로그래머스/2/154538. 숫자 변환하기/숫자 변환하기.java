import java.util.*;

class State {
    int value;
    int count;

    State(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        //최소 연산?-> BFS or DP
        
        //DP로
        /*
        DP 배열 만들고
        x부터 시작해서 +n, *2, *3 한 값을 인덱스로 해당 원소에 횟수 +1
        y 인덱스를 넘어가면 continue;
        언제 종료? -> 큐를 사용해서 방문한 곳에서만 다시 시작하고, 큐가 비었으면 종료
        */
        
        int [] DP = new int[y + 1];
        int i;
        int next;
        
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[x] = 0;
        for(i = x; i <= y; i++){
            if(DP[i] == Integer.MAX_VALUE){
                continue;
            }
            
            //1. +n
            next = i + n;
            if(next > y){
                ;
            }
            else{
                DP[next] = Math.min(DP[next], DP[i] + 1);
            }
            
            
            //2. *2
            next = i * 2;
            if(next > y){
                ;
            }
            else{
                DP[next] = Math.min(DP[next], DP[i] + 1);
            }
           
            
            //3. *3
            next = i * 3;
            if(next > y){
                ;
            }
            else{
                DP[next] = Math.min(DP[next], DP[i] + 1);
            }
        }
        
        if(DP[y] == Integer.MAX_VALUE){
            answer = -1;
        }
        else{
            answer = DP[y];
        }
        
        /*
        // 실패 + 시간초과
        int current, current_count, next;
        Queue <State> q = new LinkedList<>();
        q.offer(new State(x, 0));
        answer = -1;
        
        
        while(!q.isEmpty()){
            current = q.peek().value;
            current_count = q.peek().count;
            q.poll();
            
            //1. +n
            next = current + n;
            if(next == y){
                answer = current_count + 1;
                break;
            }
            else if(next < y){
                q.offer(new State(next, current_count + 1));
            }
            else{ // next > y
                ;
            }
            
            //2. *2
            next = current * 2;
            if(next == y){
                answer = current_count + 1;
                break;
            }
            else if(next < y){
                q.offer(new State(next, current_count + 1));
            }
            else{ // next > y
                ;
            }
            
            
            //3. *3
            next = current * 3;
            if(next == y){
                answer = current_count + 1;
                break;
            }
            else if(next < y){
                q.offer(new State(next, current_count + 1));
            }
            else{ // next > y
                ;
            }
        }
        */
        
        return answer;
    }
}