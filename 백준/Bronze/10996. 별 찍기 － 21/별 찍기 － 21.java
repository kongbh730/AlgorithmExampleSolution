import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, i = 0, j = 0;

        N = sc.nextInt();
        for(i = 0; i < N * 2; i++){
            if(i % 2 == 0){
               for(j = 0; j < N; j++){
                   if(j % 2 == 0){
                       System.out.print("*");
                   }
                   else{
                       System.out.print(" ");
                   }
               }
            }
            else{
                for(j = 0; j < N; j++){
                    if(j % 2 == 1){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }
}
