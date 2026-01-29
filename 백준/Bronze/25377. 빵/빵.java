import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, i, minTime = 1001;
        int [][] stores;

        N = sc.nextInt();
        stores = new int[N][2];
        for(i = 0; i < N; i++){
            stores[i][0] = sc.nextInt();//현재위치에서 이 가게까지 가는 데 걸리는 시간
            stores[i][1] = sc.nextInt();//가게에 들어올때까지 남은 시간
        }
        sc.close();

        for(i = 0; i < N; i++){
            if(stores[i][0] <= stores[i][1]){
                minTime = Math.min(minTime, stores[i][1]);
            }
        }

        if(minTime == 1001){
            System.out.println("-1");
        }
        else{
            System.out.println(minTime);
        }
    }
}
