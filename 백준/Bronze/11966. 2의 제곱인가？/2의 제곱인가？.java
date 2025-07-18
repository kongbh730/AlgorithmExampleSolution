import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, i;
        boolean flag = false;

        N = sc.nextInt();
        for(i = 0; i <= 30; i++){
            if(N == Math.pow(2, i)){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }

        sc.close();
    }
}
