import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int i, j;
        int currentWeight = 0;
        int time = 0;
        Queue <Integer> trucks = new LinkedList<>();
        Queue <Integer> bridge = new LinkedList<>();
        
        //큐 : offer, poll, peek
        for(int truck : truck_weights){
            trucks.offer(truck);
        }
        for(i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        while(!bridge.isEmpty()){
            time++;
            //System.out.println("time : " + time);
            
            if(trucks.isEmpty()){
                //대기 중인 트럭이 더 없음
                bridge.poll();
                
                continue;
            }
            
            if(currentWeight - bridge.peek() + trucks.peek() <= weight){
                //다리 위에 트럭이 더 올라와도 됨
                currentWeight -= bridge.peek();//현재 다리 위에 있는 트럭 한칸씩 이동
                bridge.poll();
                
                bridge.offer(trucks.peek());//대기 중인 트럭 다리에 입장
                currentWeight += trucks.peek();//무게 추가
                trucks.poll();
            }
            else{ // currentWeight - bridge.peek() + trucks.peek() > weight
                //다리 위에 트럭이 더 올라오면 안됨
                currentWeight -= bridge.peek();
                bridge.poll();
                bridge.offer(0);
            }
        }
        answer = time;
        
        return answer;
    }
}
/*
0 7
7 0
0 4
4 5
5 0
0 6
6 0
0 0


*/