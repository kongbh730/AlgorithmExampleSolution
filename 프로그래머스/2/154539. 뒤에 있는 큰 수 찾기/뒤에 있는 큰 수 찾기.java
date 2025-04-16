import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        int i;
        
        //시간때문에 완전탐색 불가
        st.push(0);//시작 인덱스 삽입
        for(i = 1; i < numbers.length; i++){
            while(!st.empty() && numbers[st.peek()] < numbers[i]){//스택이 비어있지 않고, numbers[현재 인덱스] 값이 numbers[i]보다 작은 경우 == 뒷 큰수가 될 수 있는 경우
                answer[st.peek()] = numbers[i];
                //System.out.println(numbers[st.peek()] + "의 뒷 큰 수 " + numbers[i]);
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            answer[st.peek()] = -1;
            st.pop();
        }
        
        return answer;
    }
}