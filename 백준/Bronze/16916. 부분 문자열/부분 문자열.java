import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String P, S;
        boolean flag = false;
        int i, j;
        int[] pi;

        S = br.readLine();
        P = br.readLine();

        pi = buildPi(P);

        for (i = 0, j = 0; i < S.length(); i++) {
            while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    flag = true;
                    break;
                } else {
                    j++;
                }
            }
        }

        System.out.println(flag ? 1 : 0);
    }

    static int[] buildPi(String P) {
        int[] pi = new int[P.length()];
        int j = 0;

        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
