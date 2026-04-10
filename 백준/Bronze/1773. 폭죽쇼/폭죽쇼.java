import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, C, i, j, cycle, sum = 0;
        boolean [] time;

        N = sc.nextInt();//폭죽을 터뜨리는 학생수
        C = sc.nextInt();//폭죽쇼가 끝나는 시간
        time = new boolean [C + 1];
        for(i = 0; i < N; i++){
            cycle = sc.nextInt();

            for(j = 1; j * cycle <= C; j++){
                time[j * cycle] = true;
            }
        }

        sc.close();

        for(i = 1; i <= C; i++){
            if(time[i]){
                sum++;
            }
        }

        System.out.println(sum);
    }
}
