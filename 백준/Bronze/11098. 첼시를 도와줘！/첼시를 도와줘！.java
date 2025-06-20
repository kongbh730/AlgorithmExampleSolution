import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, p, j;

        n = sc.nextInt();
        for(i = 0; i < n; i++){
            p = sc.nextInt();
            int cost, max = 0;
            String name, maxName = "";

            for(j = 0; j < p; j++){
                cost = sc.nextInt();
                name = sc.next();

                if(max < cost){
                    max = cost;
                    maxName = name;
                }
            }

            System.out.println(maxName);
        }
    }
}
