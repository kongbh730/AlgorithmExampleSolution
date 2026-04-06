import java.util.Scanner;

public class Main {
  
//    static class Hongjoon{
//        int [][] direction = {{0,1}, {1,0}, {0, -1}, {-1,0}};
//        int dir = 1;
//        int x;
//        int y;
//
//        public Hongjoon(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getDir() {
//            return dir;
//        }
//
//        public void setDir(int dir) {
//            this.dir = dir;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public void setX(int x) {
//            this.x = x;
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public void setY(int y) {
//            this.y = y;
//        }
//    }

    static class Hongjoon {
        // 1. 내부 상태 캡슐화
        private int x, y;
        private int dir = 1; // 초기 남쪽 방향 (코드의 direction 배열 기준)

        // 방향 데이터는 클래스 내부에서 상수로 관리
        private static final int[][] DELTAS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public Hongjoon(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 2. 명령을 수행하는 메서드 (동사 중심)
        public void executeCommand(char cmd, char[][] map) {
            if (cmd == 'R') {
                rotateRight();
            } else if (cmd == 'L') {
                rotateLeft();
            } else if (cmd == 'F') {
                moveForward(map);
            }
        }

        private void rotateRight() {
            this.dir = (this.dir + 1) % 4;
        }

        private void rotateLeft() {
            this.dir = (this.dir + 3) % 4;
        }

        private void moveForward(char[][] map) {
            this.y += DELTAS[dir][0];
            this.x += DELTAS[dir][1];
            map[this.y][this.x] = '.'; // 방문 표시
        }

        // 좌표 정보가 필요할 때만 Getter 제공
        public int getX() { return x; }
        public int getY() { return y; }
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
                hongjoon.executeCommand('R',map);
                //System.out.println(hongjoon.getDir());
                //System.out.println(Arrays.toString(hongjoon.direction[hongjoon.getDir()]));
            }
            else if(string[i] == 'L'){//왼쪽 회전
                hongjoon.executeCommand('L',map);
                //hongjoon.setDir((hongjoon.getDir() + 3) % 4);
                //System.out.println(hongjoon.getDir());
                //System.out.println(Arrays.toString(hongjoon.direction[hongjoon.getDir()]));
            }
            else if(string[i] == 'F'){//전진
                hongjoon.executeCommand('F',map);
                //hongjoon.setX(hongjoon.getX() + hongjoon.direction[hongjoon.getDir()][1]);
                //hongjoon.setY(hongjoon.getY() + hongjoon.direction[hongjoon.getDir()][0]);
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
