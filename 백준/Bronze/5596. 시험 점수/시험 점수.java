import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] minguk = new int[4];
    static int [] manse = new int[4];

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;

        for(i = 0; i < minguk.length; i++){
            minguk[i] = sc.nextInt();
        }
        for(i = 0; i < manse.length; i++){
            manse[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int findAnswer(){
        int mingukSum = 0, manseSum = 0, i;

        for(i = 0; i < minguk.length; i++){
            mingukSum += minguk[i];
        }
        for(i = 0; i < manse.length; i++){
            manseSum += manse[i];
        }

        return Math.max(mingukSum, manseSum);
    }
}
