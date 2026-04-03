import java.util.Scanner;

public class Main {
    static class Table {
        int H, W, N, M, maxCount;

        public int getH() {
            return H;
        }

        public void setH(int h) {
            H = h;
        }

        public int getW() {
            return W;
        }

        public void setW(int w) {
            W = w;
        }

        public int getN() {
            return N;
        }

        public void setN(int n) {
            N = n;
        }

        public int getM() {
            return M;
        }

        public void setM(int m) {
            M = m;
        }

        public void findAnswer(){
            int i, j;

            for(i = 0; i < H; i += (N+1)){
                for(j = 0; j < W; j += (M+1)){
                    maxCount++;
                }
            }
        }

        public int getMaxCount(){
            return maxCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H, W, N, M;

        Table table = new Table();
        table.setH(sc.nextInt());
        table.setW(sc.nextInt());
        table.setN(sc.nextInt());
        table.setM(sc.nextInt());
        
        table.findAnswer();
        System.out.println(table.getMaxCount());
    }
}
