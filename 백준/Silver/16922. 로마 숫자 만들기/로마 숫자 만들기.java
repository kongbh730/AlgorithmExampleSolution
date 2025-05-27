import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<Integer> numbers = new HashSet<>();
    static int []values = {1, 5, 10, 50};
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();

        System.out.println(findAnswer());

        sc.close();
    }

    public static int findAnswer() {
        int i;
        //N = 2일 때
        // II, IV, IX, IL, VV, VX, VL, XX, XL, LL -> 10개

        //N = 3일 때?
        // III, IIV, IIX, IIL, IVV, IVX, IVL, IXX, IXL, ILL, ....
        // -> 조합, 순서 상관없이 중복을 허용하지 않는 조합을 구해야 함

        DFS(0, 0, 0);

        return numbers.size();
    }

    public static void DFS(int count, int start, int sum) {
        if(count == N){
            //System.out.println(sum);
            numbers.add(sum);
            return;
        }

        for(int i = start; i < values.length; i++){
            DFS(count + 1, i, sum + values[i]);
        }
    }
}
