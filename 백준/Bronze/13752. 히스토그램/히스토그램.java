import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] testcase = new int[n];
        int i, j;

        for(i = 0; i < n; i++){
            testcase[i] = sc.nextInt();
        }
        sc.close();

        for(i = 0; i < n; i++){
            for(j = 0; j < testcase[i]; j++){
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
