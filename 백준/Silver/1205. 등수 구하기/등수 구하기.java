import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int N, taesooNewScore, P;
    static int []list;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        int i;

        N = sc.nextInt();
        taesooNewScore = sc.nextInt();
        P = sc.nextInt();
        list = new int[N];

        for(i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
    }

    public static int findAnswer() {
        int answer = 0;
        int i, rank;

        if(N == P && taesooNewScore <= list[list.length-1])
            answer = -1;
        else{
            rank = 1;
            for(i=0; i<list.length; i++){
                if(taesooNewScore < list[i])
                    rank++;
                else
                    break;
            }
            answer = rank;
        }

        return answer;
    }
}
