import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        int i, j;

        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                if(i == 1 && j == 1){
                    System.out.print(":" + str + ":");
                }
                else{
                    System.out.print(":fan:");
                }
            }
            System.out.println();
        }
    }
}
