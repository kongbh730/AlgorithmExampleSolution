import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int N, D;
    static int [][] shortCut;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswerByDP());

        scanner.close();
    }

    public static void inputData(){
        //System.out.println("inputData()");
        int i;

        N = scanner.nextInt();
        D = scanner.nextInt();
        shortCut = new int[N][3];
        for(i = 0; i < N; i++){
            shortCut[i][0] = scanner.nextInt();
            shortCut[i][1] = scanner.nextInt();
            shortCut[i][2] = scanner.nextInt();
        }
    }

    public static int findAnswerByDP(){
        //System.out.println("findAnswerByDP()");
        int answer = 0;
        int [] DP = new int[D + 1];
        int i, j;

        //D로 가는데 필요한 거리 초기화//<- 0가는데 필요한 거리 0 ~ D가는데 필요한 거리 D...
        for(i = 0; i <= D; i++){
            DP[i] = i;
        }

//        System.out.print("최초 이동거리 : ");
//        for(i = 1; i <= D; i++){
//            System.out.print(DP[i] + " ");
//        }

        //System.out.print("\n짧은 이동거리 : ");
        for(i = 1; i <= D; i++){//현재 위치
            DP[i] = Math.min(DP[i], DP[i-1] + 1);//지름길을 거쳐와서 이동거리가 줄었는지 확인
            for(j = 0; j < N; j++){//현재 위치가 지름길 사용 직후 위치와 동일하다면?
                if(shortCut[j][1] == i){
                    DP[i] = Math.min(DP[i], DP[shortCut[j][0]] + shortCut[j][2]);//지름길을 탄게 그대로 온거보다 짧은지 판단
                }
            }
            //System.out.print(DP[i] + " ");
        }
        //System.out.println();
        answer = DP[D];

        return answer;
    }
}
