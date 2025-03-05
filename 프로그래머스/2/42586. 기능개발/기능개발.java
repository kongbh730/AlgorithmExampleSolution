import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days++;
            }
            queue.offer(days);
        }
        
        while (!queue.isEmpty()) {
            int count = 1;
            int first = queue.poll(); 
            
            while (!queue.isEmpty() && queue.peek() <= first) {
                count++;
                queue.poll();
            }
            
            result.add(count);
            System.out.println(count + "개 배포");
        }
        
        answer = new int[result.size()];
        int i = 0;
        for(int temp : result){
            answer[i] = temp;
            i++;
        }
        
        return answer;
    }
}