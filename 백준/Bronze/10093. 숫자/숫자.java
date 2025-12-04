import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A, B, temp, i, count;

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        if (A > B) {
            temp = A;
            A = B;
            B = temp;
        }

        StringBuilder sb = new StringBuilder();
        count = Math.max(B - A - 1, 0);
        sb.append(count).append('\n');

        if (count > 0) {
            for (i = A + 1; i < B; i++) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }
}
