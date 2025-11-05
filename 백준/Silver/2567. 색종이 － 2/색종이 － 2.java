import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [][] papers;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        papers = new int[sc.nextInt()][2];
        for(i = 0; i < papers.length; i++){
            papers[i][0] = sc.nextInt();//색종이의 왼쪽변과 도화지 왼쪽변 사이의 거리 : x좌표
            papers[i][1] = sc.nextInt();//색종이의 아래변과 도화지 아래변 사이의 거리 : ㅛ좌표
        }
        sc.close();
    }

    public static int findAnswer(){
        boolean [][] map = new boolean[101][101];
        int i, j, k, x, y;

        for(i = 0; i < papers.length; i++){
            x = papers[i][0];
            y = papers[i][1];

            for(j = x; j < x + 10; j++){
                for(k = y; k < y + 10; k++){
                    map[k][j] = true;
                }
            }
        }

        int [][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int sum = 0, nextX, nextY, currentX, currentY;

        for(i = 0; i <= 100; i++){
            for(j = 0; j <= 100; j++){
                currentX = j;
                currentY = i;
                if(!map[i][j]){// 안 칠해져 있으면?
                    continue;
                }

                for(k = 0; k < direction.length; k++){
                    nextY = currentY + direction[k][1];
                    nextX = currentX + direction[k][0];

                    if(nextX < 0 || nextX > 100 || nextY < 0 || nextY > 100 || !map[nextY][nextX]){
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}
