import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Integer> map;
    public static void main(String[] args) {
        int T = sc.nextInt();
        int i;

        for(i = 0; i < T; i++){
            inputData();
            System.out.println(findAnswer());
        }

        sc.close();
    }

    public static void inputData(){
        int N = sc.nextInt();
        int i;
        String str;

        map = new HashMap<>();
        for(i = 0; i < N; i++){
            str = sc.next();
            map.put(str, map.getOrDefault(str,0) + 1);
        }
    }

    public static int findAnswer(){
        int answer = map.size();

        return answer;
    }
}
