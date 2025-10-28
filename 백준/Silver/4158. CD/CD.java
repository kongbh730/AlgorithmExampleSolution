import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] sangguenCD;
    static int[] sunyoungCD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            sangguenCD = new int[N];
            sunyoungCD = new int[M];

            for (int i = 0; i < N; i++) {
                sangguenCD[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                sunyoungCD[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(findAnswer());
        }
    }

    public static int findAnswer() {
        int answer = 0;

        //이분탐색으로 sangguenCD배열의 원소가 sunyoungCD배열에 존재하는지 탐색
        //정렬한 채로 삽입된 상태

        for (int key : sangguenCD) {
            int left = 0, right = sunyoungCD.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (sunyoungCD[mid] == key) {
                    answer++;
                    break;
                } else if (sunyoungCD[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return answer;
    }
}
