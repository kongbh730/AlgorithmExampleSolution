import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        //n = 1 : 1
        //n = 2 : 2
        //n = 3 : 3
        //n = 4 : 5
        //n = 5 : 6
        //n = 6 : 8
        //n = 7 : 9
        //n = 8 : 11

        int count = 0;
        int i;

        for(i = 1; i * i <= N; i++){
            count += (N / i) - i + 1;
        }
        System.out.println(count);
    }
}
