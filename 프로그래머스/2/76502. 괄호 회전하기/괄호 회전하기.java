import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1, count = 0;
        int i, j, current, length = s.length();
        char parentheses;
        
        for(i = 0; i < length; i++){
            Stack <Character> st = new Stack <>();
            //왼쪽으로 i만큼 회전했다고 치고,
            for(j = 0; j < length; j++){
                current = (j + i) % length; //회전한 인덱스
                parentheses = s.charAt(current);// 해당 인덱스의 괄호 문자
                
                //System.out.print(current + " ");
                //System.out.print(parentheses + " ");
                
                if(st.isEmpty()){//스택이 비어있으면 바로 추가
                    st.push(parentheses);// java의 스택 추가는 push
                }
                else if(st.peek() == '[' && parentheses == ']'){//스택의 머리 값 확인
                    st.pop();
                }
                else if(st.peek() == '(' && parentheses == ')'){
                    st.pop();
                }
                else if(st.peek() == '{' && parentheses == '}'){
                    st.pop();
                }
                else{
                    st.push(parentheses);
                }
            }
            if(st.isEmpty()){
                //System.out.print (" O ");
                count++;
            }
            else{
                //System.out.print(" X ");
            }
            System.out.println();
        }
        answer = count;
        
        return answer;
    }
}