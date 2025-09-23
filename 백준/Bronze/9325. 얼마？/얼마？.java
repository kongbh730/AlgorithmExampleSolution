import java.util.Scanner;

public class Main {
    static class TestCase{
        int s;
        int n;
        int [][] options;
    }

    static TestCase [] testCases;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int T, i, j;

        T = sc.nextInt();
        testCases = new TestCase[T];
        for(i = 0; i < T; i++){
            testCases[i] = new TestCase();
            testCases[i].s = sc.nextInt();
            testCases[i].n = sc.nextInt();
            testCases[i].options = new int[testCases[i].n][2];
            for(j = 0; j < testCases[i].n; j++){
                testCases[i].options[j][0] = sc.nextInt();
                testCases[i].options[j][1] = sc.nextInt();
            }
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j;

        for(i = 0; i < testCases.length; i++){
            int sum = 0;

            sum += testCases[i].s;
            for(j = 0; j < testCases[i].n; j++){
                sum += (testCases[i].options[j][0] * testCases[i].options[j][1]);
            }
            System.out.println(sum);
        }
    }
}
