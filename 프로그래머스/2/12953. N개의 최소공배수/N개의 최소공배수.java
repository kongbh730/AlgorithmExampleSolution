class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int i, A, B;
        
        //여러 숫자의 최소 공배수
        A = arr[0];
        for(i = 1; i < arr.length; i++){
            B = arr[i];
            System.out.print(A + "와 " + B + "의 최소 공배수 : ");
            A = LCM(A, B);
            System.out.println(A);
        }
        answer = A;
        
        return answer;
    }
    
    public int LCM(int A, int B){
        return A * B / GCD(A, B);
    }
    
    public int GCD(int A, int B){
        int temp, GCD = 0;
        
        if(A < B){
            temp = A;
            A = B;
            B = temp;
        }
        
        while(true){
            if(A % B == 0){
                break;
            }
            temp = A;
            A = B;
            B = temp % B;
        }
        GCD = B;
        
        return GCD;
    }
}