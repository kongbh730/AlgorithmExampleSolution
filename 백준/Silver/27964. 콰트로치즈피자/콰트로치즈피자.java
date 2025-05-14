import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N, i;
        String topping;

        N = sc.nextInt();
        Set<String> toppings = new HashSet<>();
        for (i = 0; i < N; i++) {
            topping = sc.next();
            if(topping.endsWith("Cheese")) {
                toppings.add(topping);
            }
        }

//        for(String cheese: toppings) {
//            System.out.println(cheese);
//        }

        if(toppings.size() >= 4) {
            System.out.println("yummy");
        }
        else{
            System.out.println("sad");
        }
    }
}
