import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int [] testcase;

    public static void main(String[] args) {
        inputData();

        ArrayList<Integer> tri = new ArrayList<>();
        for (int n = 1; ; n++) {
            int t = n * (n + 1) / 2;
            if (t > 1000) break;
            tri.add(t);
        }

        for(int i = 0; i < testcase.length; i++){
            int K = testcase[i];
            int result = 0;
            
            for (int a = 0; a < tri.size() && result == 0; a++) {
                for (int b = 0; b < tri.size() && result == 0; b++) {
                    for (int c = 0; c < tri.size(); c++) {
                        if (tri.get(a) + tri.get(b) + tri.get(c) == K) {
                            result = 1;
                            break;
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static void inputData(){
        int T, i;
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        testcase = new int[T];
        for(i = 0; i < T; i++){
            testcase[i] = sc.nextInt();
        }

        sc.close();
    }

}
