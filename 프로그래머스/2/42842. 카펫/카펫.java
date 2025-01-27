class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0, height = 0;
        int i, temp;
        
        for(i = 1; i * i <= yellow; i++)
        {
            if(yellow % i == 0){
                width = yellow / i;
                height = i;
                if(brown == ((width * 2) + (height * 2) + 4)){
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }
        if(answer[0] < answer[1]){
            temp = answer[0];
            answer[0] = answer[1];
            answer[1] = temp;
        }
        
        return answer;
    }
}