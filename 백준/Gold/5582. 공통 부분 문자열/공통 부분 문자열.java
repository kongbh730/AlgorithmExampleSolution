import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String A, B;
        A = sc.next();
        B = sc.next();
        System.out.println(findAnswer(A, B));

        sc.close();
    }

    public static int findAnswer(String A, String B) {
        //System.out.println("findAnswer()");
        int answer = 0;
        int ALength = A.length();
        int BLength = B.length();
        int [][] DP = new int[ALength+1][BLength+1];
        int i, j;

        // LCS : 최장 공통 부분수열 알고리즘
//        System.out.print("  ");
//        for(i = 0; i < BLength; i++) {
//            System.out.print(B.charAt(i) + " ");
//        }
//        System.out.println();
        for(i = 1; i <= ALength; i++) {
            //System.out.print(A.charAt(i-1) + " ");
            for(j = 1; j <= BLength; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {//공통문자이면
                    DP[i][j] = DP[i-1][j-1] + 1;//이전 공통문자열 길이 + 1
                }
                else{//공통문자가 아니면
                    DP[i][j] = 0;//최장 공통 문자열이 끊김
                }

                //최대값 찾으면 갱신
                answer = Math.max(answer, DP[i][j]);

                //System.out.print(DP[i][j] + " ");
            }
            //System.out.println();
        }

        return answer;
    }
}
