import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int current = n, count = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");
        
        /*
            1   2   3   4   5   6   7   8   
            1   1   2   1   2   2   3   1
        */
        
        /*
            5000 2500 1250 625 624 312 156 78 39 38 17 16 8 4 2 1    
        */
        
        while(true){
            if(current == 1){
                count++;
                //System.out.println("current : " + current + ", count : " + count);
                break;
            }
            
            if(current % 2 == 0){
                current = current / 2;
            }
            else{
                current = current - 1;
                count++;
            }
            //System.out.println("current : " + current + ", count : " + count);
        }
        ans = count;

        return ans;
    }
}