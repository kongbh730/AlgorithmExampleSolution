import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String [] A;
    static String [] B;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        A = new String[n];
        B = new String[n];

        int i;

        for(i = 0; i < n; i++){
            String [] str = sc.nextLine().split(" ");

            A[i] = str[0];
            B[i] = str[1];
        }

        sc.close();

//        for(i = 0; i < n; i++){
//            System.out.println(A[i] + " | " + B[i]);
//        }
    }

    public static void findAnswer() {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            char[] a = A[i].toCharArray();
            char[] b = B[i].toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            String sa = new String(a);
            String sb = new String(b);

            //System.out.println(sa + " | " + sb);

            if (sa.equals(sb)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
