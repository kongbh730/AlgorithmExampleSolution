import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] scores;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i;

        scores = new int[5];
        for(i = 0; i < 5; i++){
            scores[i] = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, max = 0, maxIndex = 0;

        for(i = 0; i < 5; i++){
            if(scores[i] > max){
                max = scores[i];
                maxIndex = i + 1;
            }
        }

        System.out.println(maxIndex + " " + max);
    }
}
