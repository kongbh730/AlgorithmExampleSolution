import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T, N;

        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            Map<String, Integer> clothes = inputClothes(N);

            System.out.println(findAnswer(clothes));
        }

        sc.nextLine();
    }

    public static Map<String, Integer> inputClothes(int N) {
        Map<String, Integer> clothes = new HashMap<>();
        String kind;
        String name;

        for(int i = 0; i < N; i++) {
            name = sc.next();
            kind = sc.next();

            clothes.put(kind, clothes.getOrDefault(kind, 0) + 1);
        }

        return clothes;
    }

    public static int findAnswer(Map<String, Integer> clothes){
        int answer = 1;
        int N = clothes.size();

        /*
        hat headgear
        sunglasses eyewear
        turban headgear

        clothes[headgear] == 2
        clothes[eyewear] == 1이니까

        headgear 안입거나 입는 경우 3
        eyewear 안입거나 입는 경우 2
        조합의 경우 3 * 2 - 1 = 5
        */
        for (int count : clothes.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
