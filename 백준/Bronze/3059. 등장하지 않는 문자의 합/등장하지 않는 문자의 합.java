import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, j;
        String str;
        int sum = 0, temp_sum;

        for(i = 'A'; i <= 'Z'; i++){
            sum += i;
        }
       // System.out.println(sum);

        T = sc.nextInt();
        for(i = 0; i < T; i++){
            temp_sum = sum;
            Set<Integer> set = new HashSet<>();
            str = sc.next();

            for(j = 0; j < str.length(); j++){
                set.add((int) str.charAt(j));
            }

            for(int num : set){
                //System.out.print(num + " ");
                temp_sum -= num;
            }
            System.out.println(temp_sum);
        }
    }
}
