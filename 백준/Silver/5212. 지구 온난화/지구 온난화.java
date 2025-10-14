import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char [][] map;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int R, C, i, j;

        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R + 2][C + 2];
        for(i = 0; i < map.length; i++){
            Arrays.fill(map[i], '.');
        }
        for(i = 1; i <= R; i++){
            String str = sc.next();
            for(j = 1; j <= C; j++){
                map[i][j] = str.charAt(j - 1);
            }
        }

        sc.close();
    }

    public static void findAnswer(){
        int R = map.length - 2, C = map[0].length - 2;
        int i, j, k;
        int [][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int minR = R + 1, maxR = 0;
        int minC = C + 1, maxC = 0;

        for(i = 1; i <= R; i++){
            for(j = 1; j <= C; j++){
                int count = 0;

                if(map[i][j] == 'X'){ // 아직 육지
                    for(k = 0; k < direction.length; k++){//주변 3칸 이상이 바다인지?
                        if(map[i + direction[k][0]][j + direction[k][1]] == '.'){
                            count++;
                        }
                    }

                    if(count >= 3){
                        map[i][j] = 'x'; // 물에 잠길 예정
                    }
                    else{ // 물에 잠기지 않을 예정이라면 최소 넓이 갱신
                        minR = Math.min(minR, i);
                        maxR = Math.max(maxR, i);
                        minC = Math.min(minC, j);
                        maxC = Math.max(maxC, j);
                    }
                }
            }
        }

        //임시 땅 출력
//        for(i = 0; i < map.length; i++){
//            for(j = 0; j < map[i].length; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        
        for (i = minR; i <= maxR; i++) {
            for (j = minC; j <= maxC; j++) {
                System.out.print(map[i][j] == 'X' ? 'X' : '.');
            }
            System.out.println();
        }
    }
}
