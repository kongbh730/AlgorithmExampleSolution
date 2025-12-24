import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, A, B, C;
        String order = "";

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        order = sc.next();
        sc.close();

        int [] arr = {A, B, C};
        Arrays.sort(arr);

        for(i = 0; i < order.length(); i++){
            if(order.charAt(i) == 'A'){
                System.out.print(arr[0]);
            }
            else if(order.charAt(i)== 'B'){
                System.out.print(arr[1]);
            } else if (order.charAt(i) == 'C') {
                System.out.print(arr[2]);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
