import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        //DP문제? 그리디 알고리즘?
        //0보다 작을수는 없지만 storey보다는 얼마든지 커도 됨...
        
        //16에서 10을 가는 방법?
        //16 -> 15 -> 14 -> 13 -> 12 -> 11 -> 10
        //16 -> 17 -> 18 -> 19 -> 20 -> 10
        
        //15에서 10을 가는 방법
        //15 -> 14 -> 13 -> 12 -> 11 -> 10
        //15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 10
    
        //14에서 10을 가는 방법
        //14 -> 13 -> 12 -> 11 -> 10
        //14 -> 15 -> 16 -> 17 -> 18 -> 19 -> 20 -> 10
        
        //6, 7, 8, 9면 +1하고,
        //1, 2, 3, 4, 5면 -1하고,
        
        while (storey > 0) {
            int digit = storey % 10;         
            int next = (storey / 10) % 10;     

            if (digit > 5 || (digit == 5 && next >= 5)) {
                answer += (10 - digit); 
                storey += (10 - digit); 
            } else {
                answer += digit; 
            }

            storey /= 10;
        }
        
        return answer;
    }
}