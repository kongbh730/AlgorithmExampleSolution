import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> primary_belt = new LinkedList<>();
        Stack<Integer> secondary_belt = new Stack<>();

        // 1부터 order.length까지 큐에 삽입
        for (int i = 1; i <= order.length; i++) {
            primary_belt.offer(i);
        }

        int idx = 0; // order 배열 인덱스

        while (true) {
            // 먼저 스택에서 확인 (top이 order[idx]와 같으면 pop)
            while (!secondary_belt.isEmpty() && secondary_belt.peek() == order[idx]) {
                secondary_belt.pop();
                idx++;
                answer++;
            }

            // 큐가 비어있다면 더 이상 꺼낼 수 있는 상자 없음
            if (primary_belt.isEmpty()) {
                break;
            }

            // 큐에서 상자를 하나 꺼냄
            int current = primary_belt.poll();

            if (current == order[idx]) {
                // 바로 실을 수 있다면
                idx++;
                answer++;
            } else {
                // 아니면 스택에 보관
                secondary_belt.push(current);
            }
        }

        return answer;
    }
}
