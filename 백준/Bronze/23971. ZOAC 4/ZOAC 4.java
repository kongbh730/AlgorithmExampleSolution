import java.util.Scanner;

public class Main {

    static class Table {
        private int height;
        private int width;
        private int rowGap;
        private int colGap;

        public Table(int height, int width, int rowGap, int colGap) {
            this.height = height;
            this.width = width;
            this.rowGap = rowGap;
            this.colGap = colGap;
        }

        public int calculateMaxCount() {
            int rowCount = (height + rowGap) / (rowGap + 1);
            int colCount = (width + colGap) / (colGap + 1);
            
            return rowCount * colCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        Table table = new Table(h, w, n, m);
        System.out.println(table.calculateMaxCount());

        sc.close();
    }
}