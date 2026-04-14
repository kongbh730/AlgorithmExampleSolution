import java.util.Scanner;

public class Main {
    static class Profit {
        private int cash;
        private int totalStockCount = 0; // 총 보유 주식 수만 알면 됨

        public Profit(int cash) {
            this.cash = cash;
        }

        public void buyAll(int stockPrice) {
            if (cash >= stockPrice) {
                int count = cash / stockPrice;
                this.totalStockCount += count;
                this.cash -= (count * stockPrice);
            }
        }

        public void sellAll(int stockPrice) {
            if (totalStockCount > 0) {
                this.cash += (totalStockCount * stockPrice);
                this.totalStockCount = 0;
            }
        }

        public int calculateResult(int lastStockPrice) {
            return this.cash + (this.totalStockCount * lastStockPrice);
        }
    }

    static Profit joonhyeon;
    static Profit sungmin;
    static int [] stockPrices = new int [14];

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int cash, i;

        cash = sc.nextInt();
        joonhyeon = new Profit(cash);
        sungmin = new Profit(cash);

        for(i = 0; i < stockPrices.length; i++){
            stockPrices[i] = sc.nextInt();
        }
    }

    public static void findAnswer() {
        for (int i = 0; i < 14; i++) {
            // 준현이
            joonhyeon.buyAll(stockPrices[i]);

            // 성민이
            if (i >= 3) {
                // 3일 연속 하락 (매수 조건)
                if (stockPrices[i-3] > stockPrices[i-2] &&
                        stockPrices[i-2] > stockPrices[i-1] &&
                        stockPrices[i-1] > stockPrices[i]) {
                    sungmin.buyAll(stockPrices[i]);
                }
                // 3일 연속 상승 (매도 조건)
                else if (stockPrices[i-3] < stockPrices[i-2] &&
                        stockPrices[i-2] < stockPrices[i-1] &&
                        stockPrices[i-1] < stockPrices[i]) {
                    sungmin.sellAll(stockPrices[i]);
                }
            }
        }

        int joonhyeonResult = joonhyeon.calculateResult(stockPrices[13]);
        int sungminResult = sungmin.calculateResult(stockPrices[13]);

        if (joonhyeonResult > sungminResult){
            System.out.println("BNP");
        }
        else if (joonhyeonResult < sungminResult) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}
