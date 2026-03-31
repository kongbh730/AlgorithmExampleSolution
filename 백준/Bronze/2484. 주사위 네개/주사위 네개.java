import java.util.Scanner;

public class Main {
    static class DiceResult{
        int [] result = new int[7];
    }

    static DiceResult [] diceResults;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int i;

        diceResults = new DiceResult[N];
        for(i = 0; i < N; i++){
            diceResults[i] = new DiceResult();

            diceResults[i].result[sc.nextInt()]++;
            diceResults[i].result[sc.nextInt()]++;
            diceResults[i].result[sc.nextInt()]++;
            diceResults[i].result[sc.nextInt()]++;
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j, k, sum = 0, maxSum = 0;

        for(i = 0; i < diceResults.length; i++){
            boolean flag = false;
            sum = 0;

            for(j = 1; j <= 6; j++){
                if(diceResults[i].result[j] == 4){
                    sum = 50000 + j * 5000;
                    break;
                }
                else if(diceResults[i].result[j] == 3){
                    sum = 10000 + j * 1000;
                    break;
                }
                else if(diceResults[i].result[j] == 2){
                    for(k = j; k <= 6; k++){
                        if(k != j && diceResults[i].result[k] == 2){
                            flag = true;
                            break;
                        }
                    }

                    if(flag){
                        sum = 2000 + 500 * j + 500 * k;
                    }
                    else{
                        sum = 1000 + 100 * j;
                    }
                    break;
                }
                else if(diceResults[i].result[j] == 1){
                    sum = j * 100;
                }
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
