import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");
        int i;
        Stack <Character> st = new Stack<>();
        
        for(i = 0; i < s.length(); i++){
            if(!st.empty() && st.peek() == s.charAt(i)){
                //System.out.println("st.peek() == " + st.peek() + " s.charAt(i) == " + s.charAt(i));
                st.pop();
            }
            else{//st.empty() || st.peek() != s.charAt(i)
                st.push(s.charAt(i));
            }
        }
        if(st.empty()){
            answer = 1;
        }
        else{
            answer = 0;
        }

        return answer;
    }
}