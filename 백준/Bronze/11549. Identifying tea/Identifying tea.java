import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, count = 0, type;
        int i;

        T = sc.nextInt();
        for(i = 0; i < 5; i++){
            type = sc.nextInt();
            if(type == T){
                count++;
            }
        }

        sc.close();

        System.out.println(count);
    }
}
