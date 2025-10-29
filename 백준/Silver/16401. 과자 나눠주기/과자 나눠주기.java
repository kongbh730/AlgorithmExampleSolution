import java.util.Scanner;

public class Main {
    static int N, M;
    static int [] snacks;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        M = sc.nextInt();//조카의 수
        N = sc.nextInt();//과자의 수
        snacks = new int[N];
        for(i = 0; i < N; i++){
            snacks[i] = sc.nextInt();
        }

        sc.close();
    }

    static boolean canMake(int len) {
        if (len == 0){
            return true;
        }

        long pieces = 0;

        for (int s : snacks) {
            pieces += (s / len);

            if (pieces >= M) {
                return true;
            }
        }
        return false;
    }

    public static int findAnswer() {
        int lo = 1, hi = 0, ans = 0;

        for (int s : snacks){
            hi = Math.max(hi, s);
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canMake(mid)) {
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
