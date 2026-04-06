import java.util.Scanner;

public class Main {
    static class Hongjoon{
        int [][] direction = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        int dir = 1;
        int x;
        int y;

        public Hongjoon(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    static char [] string;
    static char [][] map = new char[101][101];

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i;

        string = new char[N];
        String str = sc.next();
        for(i = 0; i < N; i++){
            string[i] = str.charAt(i);
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j;

        for(i = 0; i < map.length; i++){
            for(j = 0; j < map[i].length; j++){
                map[i][j] = '#';
            }
        }

        Hongjoon hongjoon = new Hongjoon(map.length / 2, map.length / 2);
        map[hongjoon.getY()][hongjoon.getX()] = '.';
        for(i = 0; i < string.length; i++){
            if(string[i] == 'R'){//오른쪽 회전
                hongjoon.setDir((hongjoon.getDir() + 1) % 4);
                //System.out.println(hongjoon.getDir());
                //System.out.println(Arrays.toString(hongjoon.direction[hongjoon.getDir()]));
            }
            else if(string[i] == 'L'){//왼쪽 회전
                hongjoon.setDir((hongjoon.getDir() + 3) % 4);
                //System.out.println(hongjoon.getDir());
                //System.out.println(Arrays.toString(hongjoon.direction[hongjoon.getDir()]));
            }
            else if(string[i] == 'F'){//전진
                hongjoon.setX(hongjoon.getX() + hongjoon.direction[hongjoon.getDir()][1]);
                hongjoon.setY(hongjoon.getY() + hongjoon.direction[hongjoon.getDir()][0]);
                map[hongjoon.getY()][hongjoon.getX()] = '.';
            }
        }

        int minRow = map.length, maxRow = 0;
        int minCol = map.length, maxCol = 0;

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map.length; j++) {
                if (map[i][j] == '.') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for (i = minRow; i <= maxRow; i++) {
            for (j = minCol; j <= maxCol; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
