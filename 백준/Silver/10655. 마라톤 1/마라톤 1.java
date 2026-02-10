import java.util.Scanner;

public class Main {
    static int [][] checkPoints;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;
        int N = sc.nextInt();

        checkPoints = new int[N][2];
        for(i = 0; i < N; i++){
            checkPoints[i][0] = sc.nextInt();//x
            checkPoints[i][1] = sc.nextInt();//y
        }

        sc.close();
    }

    public static int findAnswer() {
        int currentLength = 0;
        int N = checkPoints.length;
        int i, minlength = Integer.MAX_VALUE;

        // 전체 이동거리
        for (i = 1; i < N; i++) {
            currentLength += findDistance(i - 1, i);
        }

        for (i = 1; i < N - 1; i++) {
            int removed = findDistance(i - 1, i) + findDistance(i, i + 1);
            int added = findDistance(i - 1, i + 1);

            int tempLength = currentLength - removed + added;

            //갱신
            if (tempLength < minlength) {
                minlength = tempLength;
            }
        }

        return minlength;
    }

    public static int findDistance(int a, int b) {
        return Math.abs(checkPoints[a][0] - checkPoints[b][0])
                + Math.abs(checkPoints[a][1] - checkPoints[b][1]);
    }
}
