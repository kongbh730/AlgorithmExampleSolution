class Solution {
    public int solution(int n) {
        int answer = 0;
        int i;
        long [] DP = new long[n + 1];
        
        DP[0] = 0;
        DP[1] = 1;
        for(i = 2; i <= n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
            //System.out.print(DP[i] + " ");
        }
        answer = (int)DP[n];
        
        return answer;
    }
}