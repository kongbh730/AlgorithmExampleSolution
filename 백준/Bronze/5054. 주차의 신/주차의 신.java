import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, i, j;

        t = sc.nextInt();
        for(i = 0; i < t; i++){
            int n = sc.nextInt();
            Integer [] stores = new Integer[n];
            int left, right;
            
            for(j = 0; j < n; j++){
                stores[j] = sc.nextInt();
            }
            right = Collections.max(Arrays.asList(stores));
            left = Collections.min(Arrays.asList(stores));

            System.out.println((right - left) * 2);
        }

        sc.close();
    }
}
