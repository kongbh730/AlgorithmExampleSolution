import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, S;
    static int [] brothers;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        S = sc.nextInt();
        brothers = new int[N];
        for(i = 0; i < N; i++){
            brothers[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int findAnswer(){
        int answer = 0;
        int i, gcd = 0, a, b;

        //동생이 한명인 경우
        if(brothers.length == 1){
            return Math.abs(S - brothers[0]);
        }

        //동생들 위치에서 수빈이 위치 빼기
        for(i = 0; i < brothers.length; i++){
            brothers[i] = Math.abs(S - brothers[i]);
            //System.out.print(brothers[i] + " ");
        }
        //System.out.println();

        //원소들의 최대공약수 구하기
        a = brothers[0];
        for(i = 1; i < brothers.length; i++){
            b = brothers[i];
            gcd = GCD(a, b);
            //System.out.println(a + ", " + b + "의 gcd : " + gcd);
            a = gcd;
        }

        return gcd;
    }

    public static int GCD(int a, int b){
        int temp;

        while (b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
