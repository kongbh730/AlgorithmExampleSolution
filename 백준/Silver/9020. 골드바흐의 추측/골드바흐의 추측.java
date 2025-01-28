import java.util.Scanner;

public class Main {
     static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //골드바흐 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
        int T, i, n;

        T = sc.nextInt();
        for(i = 0; i < T; i++) {
            n = sc.nextInt();
            findAnswer(n);
        }

        sc.close();
    }

    public static void findAnswer(int n) {
        //System.out.println("findAnswer");
        int i, j, currentNumA, currentNumB;
        boolean flagA, flagB;

        //n은 짝수
        for(i = n/2; i >= 2; i--) {
            flagA = true;
            flagB = true;
            currentNumA = i;
            currentNumB = n - i;

            flagA = isPrime(currentNumA);
            flagB = isPrime(currentNumB);
            //System.out.println(currentNumA + "는 소수 = " + flagA + " / " + currentNumB + "는 소수 = " + flagB);

            if(flagA && flagB) {
                System.out.println(currentNumA + " " + currentNumB);
                break;
            }
        }
    }

    public static boolean isPrime(int n) {
        boolean flag = true;

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
