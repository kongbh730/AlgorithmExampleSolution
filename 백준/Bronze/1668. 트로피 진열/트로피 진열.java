import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] trophy;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int N, i;

         N = sc.nextInt();
         trophy = new int[N];
         for(i = 0; i < N; i++){
             trophy[i] = sc.nextInt();
         }
    }

    public static void findAnswer(){
        int i, left = 1, right = 1, current;

        current = trophy[0];
        for(i = 1; i < trophy.length; i++){
            if(trophy[i] > current){
                left++;
                current = trophy[i];
            }
        }

        current = trophy[trophy.length - 1];
        for(i = trophy.length - 2; i >= 0; i--){
            if(trophy[i] > current){
                right++;
                current = trophy[i];
            }
        }

        System.out.println(left);
        System.out.println(right);
    }
}
