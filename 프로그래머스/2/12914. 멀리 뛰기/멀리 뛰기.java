class Solution {
    public long solution(int n) {
        long answer = 0;
        int [] DP = new int[n + 2];
        
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        for(int i = 3; i <= n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
            System.out.print(DP[i] + " ");
        }
        answer = DP[n];
        
        return answer;
    }
}