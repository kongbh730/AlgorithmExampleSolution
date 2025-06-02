import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [][] studentData;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        int i, j;

        N = sc.nextInt();
        studentData = new int[N][5];
        for(i = 0; i < N; i++) {
            for(j = 0; j < 5; j++) {
                studentData[i][j] = sc.nextInt();
            }
        }
    }

    public static int findAnswer() {
        int answer = 0;
        int maxCount = Integer.MIN_VALUE;
        int i, j, k;
        int count;

        for (i = 0; i < N; i++) {
            count = 0;

            for (j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                else{
                    for (k = 0; k < 5; k++) {
                        if (studentData[i][k] == studentData[j][k]) {
                            count++;
                            break;
                        }
                    }
                }
            }

            if (count > maxCount) {
                maxCount = count;
                answer = i + 1; // 1번부터 시작
            }
        }

        return answer;
    }
}
