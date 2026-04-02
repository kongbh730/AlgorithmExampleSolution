import java.util.Scanner;

public class Main {
    static class Rank{
        int firstRank;
        int secondRank;

        public Rank(int firstRank, int secondRank) {
            this.firstRank = firstRank;
            this.secondRank = secondRank;
        }

        public int getFirstRank() {
            return firstRank;
        }

        public void setFirstRank(int firstRank) {
            this.firstRank = firstRank;
        }

        public int getSecondRank() {
            return secondRank;
        }

        public void setSecondRank(int secondRank) {
            this.secondRank = secondRank;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, a, b, sum = 0;
        int T = sc.nextInt();
        Rank [] ranks = new Rank[T];

        for(i = 0; i < T; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            ranks[i] = new Rank(0, 0);
            ranks[i].setFirstRank(a);
            ranks[i].setSecondRank(b);

            //System.out.println(ranks[i].firstRank + " " + ranks[i].secondRank);
        }
        sc.close();

        for(i = 0; i < T; i++){
            sum = 0;
            a = ranks[i].getFirstRank();
            b = ranks[i].getSecondRank();

            if(a == 0){
                sum += 0;
            }
            else if(a == 1){
                sum += 5000000;
            }
            else if(a <= 3){
                sum += 3000000;
            }
            else if(a <= 6){
                sum += 2000000;
            }
            else if(a <= 10){
                sum += 500000;
            }
            else if(a <= 15){
                sum += 300000;
            }
            else if(a <= 21){
                sum += 100000;
            }

            if(b == 0){
                sum += 0;
            }
            else if(b == 1){
                sum += 5120000;
            }
            else if(b <= 3){
                sum += 2560000;
            }
            else if(b <= 7){
                sum += 1280000;
            }
            else if(b <= 15){
                sum += 640000;
            }
            else if(b <= 31){
                sum += 320000;
            }

            System.out.println(sum);
        }
    }
}
