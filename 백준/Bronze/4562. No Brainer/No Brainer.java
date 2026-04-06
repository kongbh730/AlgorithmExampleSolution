import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, X, Y;

        n = sc.nextInt();
        for(i = 0; i < n; i++){
            X = sc.nextInt();
            Y = sc.nextInt();

            if(X >= Y){
                System.out.println("MMM BRAINS");
            }
            else{
                System.out.println("NO BRAINS");
            }
        }

        sc.close();
    }
}
