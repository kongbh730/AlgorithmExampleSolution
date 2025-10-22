import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][] testCases = new int [N][3];
        int i;

        for(i = 0; i < N; i++){
            testCases[i][0] = sc.nextInt();
            testCases[i][1] = sc.nextInt();
            testCases[i][2] = sc.nextInt();
        }

        sc.close();

        for(i = 0; i < N; i++){
            if(testCases[i][0] < testCases[i][1] - testCases[i][2]){
                System.out.println("advertise");
            }
            else if(testCases[i][0] == testCases[i][1] - testCases[i][2]){
                System.out.println("does not matter");
            }
            else{// testCases[i][0] > testCases[i][1] + testCases[i][2]
                System.out.println("do not advertise");
            }
        }
    }
}
