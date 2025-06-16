import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int [] location;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        M = sc.nextInt();
        location = new int[M];

        for(i = 0; i < M; i++){
            location[i] = sc.nextInt();
        }
    }

    public static int findAnswer() {
        int left = 0, right = N, answer = N;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canLightAll(mid)) {
                answer = mid;      
                right = mid - 1;
            } else {
                left = mid + 1;    
            }
        }

        return answer;
    }

    public static boolean canLightAll(int H) {
        int covered = 0;

        for (int pos : location) {
            int leftBound = pos - H;
            int rightBound = pos + H;

            if (leftBound > covered) {
                return false; 
            }

            covered = Math.max(covered, rightBound);

            if (covered >= N) break; 
        }

        return covered >= N;
    }
}
