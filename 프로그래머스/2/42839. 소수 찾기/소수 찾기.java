import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        //numbers를 사용해 가능한 모든 순열 만들기
        generateNumbers("", numbers);

        //각각의 순열에 대해 완전탐색으로 소수 찾기
        for (int num : numberSet) {
            if (primeNumber(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    //소수 구하기
    public boolean primeNumber(int num){
        int i;
        
        System.out.print(num);
        if(num < 2){
            System.out.println(" 소수 아님");
            return false;
        }
        for(i = 2; i * i <= num; i++){
            if(num % i == 0){
                System.out.println(" 소수 아님");
                return false;
            }
        }
        
        System.out.println(" 소수임");
        return true;
    }
    
    public void generateNumbers(String currentStr, String remainedStr){
        int i, num;
        
        if(!currentStr.equals("")){
            num = Integer.parseInt(currentStr);
            System.out.println(num);
            numberSet.add(num);
        }
        
        for (i = 0; i < remainedStr.length(); i++) {
            generateNumbers(currentStr + remainedStr.charAt(i), remainedStr.substring(0, i) + remainedStr.substring(i + 1));
        }
    }
}