import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        sc.close();

        if(M == 1 || M == 2) {//뉴비 : 1 or 2
            System.out.println("NEWBIE!");
        }
        else if(M <= N) {//TLE : N학년 이하이면서 뉴비가 아닌 학생
            System.out.println("OLDBIE!");
        }
        else { //올드비 : 뉴비도 올드비도 아닌 학생
            System.out.println("TLE!");
        }
    }
}
