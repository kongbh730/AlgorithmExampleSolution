import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        int N = players.length, M = callings.length, i, currentIndex;
        String calledPlayer, previousPlayer;
        Map <String, Integer> name = new HashMap<>();
        answer = new String[N];
        
        //맵에 선수 정보 저장
        for(i = 0; i < N; i++){
            name.put(players[i], i);
        }
        
        for(i = 0; i < M; i++){
            calledPlayer = callings[i];
            currentIndex = name.get(calledPlayer);
            
            //스왑 과정
            previousPlayer = players[currentIndex - 1];
            players[currentIndex - 1] = calledPlayer;
            players[currentIndex ] = previousPlayer;
            
            name.put(calledPlayer, currentIndex - 1);
            name.put(previousPlayer, currentIndex);
        }
        
        for(i = 0; i < N; i++){
            answer[i] = players[i];
        }
        
        return answer;
    }
}