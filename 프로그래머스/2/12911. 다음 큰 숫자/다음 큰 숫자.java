class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0, temp = 0;
        
        count = Integer.bitCount(n);
        //System.out.println(n + "의 비트 수 : " + count);
        
        while(temp != count){
            n++;
            temp = Integer.bitCount(n);
            //System.out.println(n + "의 비트 수 : " + temp);
        }
        answer = n;
        
        return answer;
    }
}