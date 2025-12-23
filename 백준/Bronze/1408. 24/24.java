import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int toSeconds(String t) {
        int h = Integer.parseInt(t.substring(0, 2));
        int m = Integer.parseInt(t.substring(3, 5));
        int s = Integer.parseInt(t.substring(6, 8));
        
        return h * 3600 + m * 60 + s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine().trim(); 
        String B = br.readLine().trim(); 

        int a = toSeconds(A);
        int b = toSeconds(B);

        int diff = (b - a + 24 * 3600) % (24 * 3600);
        
        if (diff == 0) {
            diff = 24 * 3600;
        } 

        int hh = diff / 3600;
        int mm = (diff % 3600) / 60;
        int ss = diff % 60;

        System.out.printf("%02d:%02d:%02d%n", hh, mm, ss);
    }
}
