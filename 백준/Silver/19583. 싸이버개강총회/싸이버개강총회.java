import java.io.*;
import java.util.*;

public class Main {
    static String S, E, Q;
    static Map<String, Boolean> attendedName = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputData(br);
        System.out.println(findAnswer());
    }

    public static void inputData(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        E = st.nextToken();
        Q = st.nextToken();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] temp = line.split(" ");
            String time = temp[0];
            String name = temp[1];

            if (time.compareTo(S) <= 0) {
                attendedName.put(name, false);
                //System.out.println(name + " 참석 시작");
            } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if (attendedName.containsKey(name)) {
                    //System.out.println(name + " 출석 완료");
                    attendedName.put(name, true);
                }
            }
        }
    }

    public static int findAnswer() {
        int answer = 0;

        for (boolean val : attendedName.values()) {
            if (val) {
                answer++;
            }
        }
        return answer;
    }
}
