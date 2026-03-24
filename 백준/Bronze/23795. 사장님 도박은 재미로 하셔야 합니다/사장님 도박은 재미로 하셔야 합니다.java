import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, sum = 0;

        while(true){
            num = sc.nextInt();

            if(num == -1){
                break;
            }
            else{
                sum += num;
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
