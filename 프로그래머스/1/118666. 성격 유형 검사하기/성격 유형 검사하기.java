import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int n = survey.length; // == choices.size()
        int i, current_choice, score;
        Map <Character, Integer> category = new HashMap<>();
        char left, right;
        
        //맵 자료구조 값 초기화
        category.put('R', 0);
        category.put('T', 0);
        category.put('C', 0);
        category.put('F', 0);
        category.put('J', 0);
        category.put('M', 0);
        category.put('A', 0);
        category.put('N', 0);
        
        for(i = 0; i < n; i++){
            left = survey[i].charAt(0);
            right = survey[i].charAt(1);
            current_choice = choices[i];
            
            if(current_choice < 4){//1,2,3 -> left에 3점, 2점, 1점
                score = 4 - current_choice;
                category.put(left, category.get(left) + score);
            }else if(current_choice > 4){//5,6,7 -> right에 1점, 2점, 3점
                score = current_choice - 4;
                category.put(right, category.get(right) + score);
            }
            
            System.out.println("left : " + left + " / right : " + right + " / choice : " + current_choice);
        }
        
        for (Character key : category.keySet()) {
            System.out.println(key + ": " + category.get(key));
        }
        
        //값이 더 큰 키 더하기, 같으면 사전순 앞인거 더하기
        answer += (category.get('R') >= category.get('T')) ? 'R' : 'T';
        answer += (category.get('C') >= category.get('F')) ? 'C' : 'F';
        answer += (category.get('J') >= category.get('M')) ? 'J' : 'M';
        answer += (category.get('A') >= category.get('N')) ? 'A' : 'N';
        //다행이 이미 사전순으로 정렬되어 있다.
        
        return answer;
    }
}