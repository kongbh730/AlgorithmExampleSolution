import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n0, n1, n2, n3, n4, i = 1;

        while(true){
            n0 = sc.nextInt();
            if(n0 == 0){
                break;
            }

            System.out.print(i + ". ");
            i++;
            n1 = n0 * 3;
            if(n1 % 2 == 0){//짝수
                System.out.print("even ");
                n2 = n1 / 2;
            }
            else{//홀수
                System.out.print("odd ");
                n2 = (n1 + 1) / 2;
            }
            n3 = 3 * n2;
            n4 = n3 / 9;

            if(n1 % 2 == 0){//짝수
                n0 = 2 * n4;
            }
            else{//홀수
                n0 = 2 * n4 + 1;
            }
            System.out.println(n4);
        }

        sc.close();
    }
}
