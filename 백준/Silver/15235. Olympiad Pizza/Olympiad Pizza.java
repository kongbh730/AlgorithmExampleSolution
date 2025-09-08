import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] contestants;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int N, i;

        N = sc.nextInt();
        contestants = new int[N];//각 참가자가 배부르기 위한 피자조각 수

        for(i = 0; i < N; i++){
            contestants[i] = sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer(){
        int N = contestants.length; // 참가자 수
        Queue<Integer> queue = new LinkedList<>();
        int [] answer = new int[N];
        int i, t = 1, current;

        for(i = 0; i < N; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            current = queue.poll();
            contestants[current]--;

            if(contestants[current] != 0){
                queue.add(current);
            }
            else{ //contestants[current] == 0
                answer[current] = t;
            }
            t++;
        }

        for(int temp : answer){
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
