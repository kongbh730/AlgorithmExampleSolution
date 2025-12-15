import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [][] map;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int N;
        int i, j;

        N = sc.nextInt();
        map = new int[N][N];
        for(i = 0; i < N; i++){
            String str = sc.next();
            for(j = 0; j < N; j++){
                if(str.charAt(j) == '.'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = str.charAt(j)-'0';
                }
            }
        }

        sc.close();
//        for(int [] temp : map){
//            for(int ch : temp){
//                System.out.print(ch);
//            }
//            System.out.println();
//        }
    }

    public static void findAnswer(){
        int N = map.length;
        int i, j, k, x, y;
        int [][] direction = {{-1,-1}, {0, -1},{1, -1},{-1, 0},{0,0},{1,0},{-1, 1},{0,1},{1,1}};

        int [][] mineField = new int[N][N];
        for(i = 0; i < N; i++){
            Arrays.fill(mineField[i], 0);
        }
        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                for(k = 0; k < direction.length; k++){
                    x = j + direction[k][1];
                    y = i + direction[k][0];

                    if(x >= 0 && x < N && y >= 0 && y < N){
                        mineField[i][j] += map[y][x];
                    }
                    if (map[i][j] > 0){
                        mineField[i][j] = -1;
                    }
                }
            }
        }

        for(int [] temp : mineField){
            for(int mine : temp){
                if(mine >= 10){
                    System.out.print("M");
                }
                else if(mine == -1){
                    System.out.print("*");
                }
                else{
                    System.out.print(mine);
                }
            }
            System.out.println();
        }
    }
}
