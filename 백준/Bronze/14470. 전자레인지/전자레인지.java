import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 원래 고기의 온도
        int B = sc.nextInt(); // 목표온도
        int C = sc.nextInt(); // 얼어있는 고기 데우는 시간
        int D = sc.nextInt(); // 얼어있는 고기 해동하는 시간
        int E = sc.nextInt(); // 얼어있지 않는 고기를 데우는 시간
        int time = 0;
        sc.close();

        if(A > 0){
            time = (B - A) * E;
        }
        else if(A == 0){
            time = D + B * E;
        }
        else{
            time = -A * C + D + B * E;
        }

        System.out.println(time);
    }
}
