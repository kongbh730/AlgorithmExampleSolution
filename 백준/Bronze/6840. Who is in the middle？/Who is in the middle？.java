import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(sc.nextInt());
        arr.add(sc.nextInt());
        arr.add(sc.nextInt());

        sc.close();

        Collections.sort(arr);
        System.out.println(arr.get(1));
    }
}
