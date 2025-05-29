class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char maxNum;
        int i, j;
        
        for(i = 0; i < number.length() - k; i++){
            maxNum = '0';
            for(j = index; j <= i + k; j++){
                if(maxNum < number.charAt(j)){
                    maxNum = number.charAt(j);
                    index = j + 1;
                    //System.out.println("maxNum : " + maxNum);
                }
            }
            sb.append(maxNum);
            //System.out.println("sb : " + sb);
        }
        answer = sb.toString();
        
        return answer;
    }
}