import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int K,M,N;
    static Map<String, Integer> map;
    static String [] t;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i, p;
        String s;

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new HashMap<>();
        t = new String[K];

        for(i = 0; i < N; i++){
            s = sc.next();
            p = sc.nextInt();

            map.put(s, p);
        }

        for(i = 0; i < K; i++){
            t[i] = sc.next();
        }

        sc.close();
    }

    public static void  findAnswer(){
        int MIN = 0, MAX = 0, sum = 0;
        int i;
        int need = M - K;

        //Map 자료구조를 원소값 기준으로 오름차순 정렬
        for (i = 0; i < K; i++) {
            Integer val = map.get(t[i]);

            //Map 자료구조의 키값과 t의 원소 값과 같은 경우 sum에 더하고 제거
            if (val != null) {
                sum += val;
                map.remove(t[i]);
            }
        }

        int[] scores = new int[map.size()];
        int idx = 0;
        for (int v : map.values()) scores[idx++] = v;
        Arrays.sort(scores);

        //정렬된 Map 자료구조를 위에서부터 N-K개 더한게 MIN값
        //정렬된 Map 자료구조를 아래에서부터 N-K개 더한게 MAX값
        for (i = 0; i < need; i++) {
            MIN += scores[i];
            MAX += scores[scores.length - 1 - i];
        }

        System.out.println((sum + MIN) + " " + (sum + MAX));
    }
}
