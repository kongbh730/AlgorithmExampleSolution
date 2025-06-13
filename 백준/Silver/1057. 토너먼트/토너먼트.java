import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N, kjm, ihs;

        N = sc.nextInt();
        kjm = sc.nextInt();
        ihs = sc.nextInt();

        System.out.println(findAnswer(N, kjm, ihs));

        sc.close();
    }

    public static int findAnswer(int N, int kjm, int ihs){
        int answer = 0;
        int i;

        while (kjm != ihs) {
            kjm = (kjm + 1) / 2;
            ihs = (ihs + 1) / 2;

            //System.out.print("kjm : " + kjm);
            //System.out.println(" ihs : " + ihs);
            answer++;
        }

        if(answer == 0){
            answer = -1;
        }

        return answer;
    }
}
