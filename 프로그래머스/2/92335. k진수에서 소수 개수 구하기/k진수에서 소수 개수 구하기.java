import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        
        String changedNum = change(n, k);
        answer = findAnswer(changedNum);
        
        return answer;
    }
    
    public String change(int n, int k){
        return Integer.toString(n, k);
    }

    public int findAnswer(String changedNum) {
        int count = 0;
        int i, j;

        String[] strs = changedNum.split("0");
    
        Map<Long, Boolean> primeCache = new HashMap<>();

    
        for (String str : strs) {
            if (str.isEmpty()) {
                continue;
            }

            long num = Long.parseLong(str);
        
            if (primeCache.containsKey(num)) {
                if (primeCache.get(num)) {
                    count++;
                }
                continue;
            }

            boolean isPrime = true;
            if (num >= 2) {
                for (j = 2; (long)j * j <= num; j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }   
            else {
                isPrime = false;
            }

            primeCache.put(num, isPrime);

            if (isPrime) {
               count++;
            }
        }

        return count;
    }
}