import java.util.Scanner;

public class Main {
    static int [] cardsA = new int[10];
    static int [] cardsB = new int[10];

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;
        Scanner sc = new Scanner(System.in);

        for(i = 0; i < 10; i++){
            cardsA[i] = sc.nextInt();
        }
        for(i = 0; i < 10; i++){
            cardsB[i] = sc.nextInt();
        }

        sc.close();
    }

    public static String findAnswer(){
        int A = 0, B = 0, i;

        for(i = 0; i < 10; i++){
            if(cardsA[i] > cardsB[i]){
                A++;
            }
            else if(cardsA[i] < cardsB[i]){
                B++;
            }
        }

        if(A > B){
            return "A";
        }
        else if(A < B) {
            return "B";
        }
        else {
            return "D";
        }
    }
}
