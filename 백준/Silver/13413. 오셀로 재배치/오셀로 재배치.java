import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static class Osello{
        int tokenNum;
        String init;
        String dest;

        Osello (int tokenNum, String init, String dest){
            this.tokenNum = tokenNum;
            this.init = init;
            this.dest = dest;
        }
    }

    static Osello [] testCase;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i;

        testCase = new Osello[sc.nextInt()];
        for(i = 0; i < testCase.length; i++){
            Osello osello = new Osello(sc.nextInt(), sc.next(), sc.next());
            testCase[i] = osello;
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j;

        for(i = 0; i < testCase.length; i++){
            int answer = 0, BCount = 0, WCount = 0;

            //init과 dest를 비교
            //init에서 BCount와 WCount를 각각 계산
            //BCount와 WCount 차이만큼?

            for(j = 0; j < testCase[i].init.length(); j++){
                if(testCase[i].init.charAt(j) != testCase[i].dest.charAt(j)){
                    if(testCase[i].init.charAt(j) == 'B'){
                        BCount++;
                    }
                    else{
                        WCount++;
                    }
                }
            }

            //System.out.println("BCount : " + BCount + " / WCount : " + WCount);
            System.out.println(Math.max(BCount, WCount));
        }
    }
}
