import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, i, k;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.close();

        int [] A = new int[n + 1];
        A[0] = 1;
        if(n >= 1){
            A[1] = 1;
        }

        for(i = 2; i < A.length; i++){
            int temp = 1;
            while(true){
                boolean flag = true;
                for(k = 1; k * 2 <= i; k++){
                    if(temp == 2 * A[i - k] - A[i - 2 * k]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    A[i] = temp;
                    break;
                }
                temp++;
            }
        }

//        for(int temp : A){
//            System.out.print(temp + " ");
//        }

        System.out.println(A[n]);
    }
}
