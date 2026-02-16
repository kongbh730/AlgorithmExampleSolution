import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Cn = sc.nextInt();
        int n = 1;

        while(Cn != 1){
            if(Cn % 2 == 0){//짝수
                Cn = Cn / 2;
            }
            else{//홀수
                Cn = 3 * Cn + 1;
            }
            n++;

            //System.out.println("Cn : " + Cn);
            //System.out.println("n : " + n);
        }

        System.out.println(n);
    }
}
