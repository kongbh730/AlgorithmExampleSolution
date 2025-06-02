class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        //비내림차순 : 오름차순인데, 현재 항과 다음 항이 같을 수 있음
        //비오름차순 : 내림차순인데, 현재 항과 다음 항이 같을 수 있음
        
        int N = sequence.length;
        int sum = 0;
        //int currentMinLength = N;
        int left = 0, right = 0;
        //int [] DP = new int [N + 1];
        int i, j;
        int minLength = N + 1;
        answer = new int[2];

        while (true) {
            if (sum >= k) {//sum이 k와 같거나 큼
                if (sum == k && (right - left) < minLength) {
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left];
                left++;
            } 
            else if (right == N) {//가장 마지막까지 접근, 종료
                break;
            } 
            else {//sum이 k보다 작음
                sum += sequence[right];
                right++;//right 한칸 오른쪽 이동
            }
            //System.out.println(left + " ~ " + right + " : " + sum);
        }
        
        /*
        DP[0] = 0; 
        for(i = 1; i <= N; i++){
            DP[i] = DP[i-1] + sequence[i-1];
        }
        
        // for(int temp : DP){
        //     System.out.print(temp + " ");
        // }
        // System.out.println();
        
        for(i = 0; i <= N; i++){
            for(j = i + 1; j <= N; j++){
                sum = DP[j] - DP[i];
                //System.out.println("i : " + i + ", j : " + j + ", DP[j] - DP[i] == " + (DP[j] - DP[i]));
                if(sum == k && j - i < currentMinLength){
                    currentMinLength = j - i;
                    left = i;
                    right = j;
                    //System.out.println("currentMinLength : " + currentMinLength + " left : " + left + " right : " + right);
                    break;
                }
            }
        }
        answer = new int[2];
        answer[0] = left;
        answer[1] = right - 1;
        */
        
        return answer;
    }
}