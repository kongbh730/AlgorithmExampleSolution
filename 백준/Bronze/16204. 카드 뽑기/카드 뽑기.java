import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, K;

        N = sc.nextInt();//카드 개수
        M = sc.nextInt();//O가 한 개 적인 카드 수
        K = sc.nextInt();
        sc.close();

        //EX
        /*N = 4, M = 3, K = 2일때
        앞면 : O O O X
        뒷면 : O O X X : O를 K개, X를 N-K개 적음
        이때 앞면과 뒷면에 같은 모양이 적혀있는 카드의 최대 개수?
        앞면에 O, 뒷면에 O가 적힌 최대 개수 = min(M, K)
        앞면에 X, 뒷면에 X가 적힌 최대 개수 = min(N-M ,N-K)
        * */

        System.out.println(Math.min(M, K) + Math.min(N - M, N - K));
    }
}
