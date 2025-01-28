import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, weight = 0;
        int i, left = 0, right = people.length - 1;
        
        //그리디 : 그 상황에서 최선의 방법
        Arrays.sort(people);
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++; 
        }
        
        return answer;
    }
}