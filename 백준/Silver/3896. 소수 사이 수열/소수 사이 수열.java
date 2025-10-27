import java.util.Scanner;

public class Main {
    static int [] testcase;
    static final int MAX = 1299709;
    static boolean[] isComposite;

    public static void main(String[] args) {
        inputData();
        sieve();
        findAnswer();
    }

    public static void inputData(){
        int T, i;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        testcase = new int[T];
        for(i = 0; i < T; i++){
            testcase[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void sieve() {
        isComposite = new boolean[MAX + 1];
        if (MAX >= 0) {
            isComposite[0] = true;
        }
        if (MAX >= 1) {
            isComposite[1] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (!isComposite[i]) {
                for (int m = i * i; m <= MAX; m += i) {
                    isComposite[m] = true;
                }
            }
        }
    }

    public static void findAnswer(){
        //k를 포함하는 소수 사이 수열의 길이
        //k = 10일때 소수 7, 11 : 길이는 4
        //k = 2일때 소수 2, 길이는 0

        for(int k : testcase){
            // k가 소수면 0
            if (!isComposite[k]) {
                System.out.println(0);
                continue;
            }

            // 아래쪽 소수 L 찾기
            int L = k - 1;
            while (L >= 2 && isComposite[L]) L--;

            // 위쪽 소수 U 찾기
            int U = k + 1;
            while (U <= MAX && isComposite[U]) U++;

            System.out.println(U - L);
        }
    }
}
