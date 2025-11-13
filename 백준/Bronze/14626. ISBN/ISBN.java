import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S;
        int [] StoArr;
        int N = 0, i, missingIndex = 0, m, answer = 0, currentN;

        S = sc.next();
        sc.close();
        StoArr = new int[S.length()];
        for(i = 0; i < S.length(); i++){
            StoArr[i] = S.charAt(i) - '0';
            if(S.charAt(i) == '*'){
                missingIndex = i;
            }
        }

        for(i = 0; i < S.length() - 1; i++){
            if(i == missingIndex){
                continue;
            }

            if(i % 2 == 0){
                N += StoArr[i];
            }
            else{
                N += StoArr[i] * 3;
            }
        }

        m = StoArr[StoArr.length - 1];
        for(i = 0; i <= 9; i++){
            currentN = N;
            if(missingIndex % 2 == 0){
                currentN += i;
            }
            else{
                currentN += i * 3;
            }

            if (m == (10 - (currentN % 10)) % 10) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
