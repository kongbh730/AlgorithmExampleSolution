class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryString = Integer.toBinaryString(n);
        int count = 0, temp;
        int i, j;
        
        //System.out.println(binaryString);
        //이렇게 하면 시간이 너무 오래 걸릴거 같은데....
        for(i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) == '1'){
                count++;
            }
        }
        
        while(true){
            n++;
            String tempBinaryString = Integer.toBinaryString(n);
            temp = 0;
            
            //System.out.println(n + " " + tempBinaryString);
            for(i = 0; i < tempBinaryString.length(); i++){
                if(tempBinaryString.charAt(i) == '1'){
                    temp++;
                }
            }
            if(temp == count){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}