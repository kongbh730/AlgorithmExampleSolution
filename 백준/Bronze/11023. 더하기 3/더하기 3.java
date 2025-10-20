import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, sum = 0;
        String [] numbers = sc.nextLine().split(" ");
        sc.close();

        for(i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }

        System.out.println(sum);
    }
}
