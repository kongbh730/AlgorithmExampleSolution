import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A, B;
        int i;
        int []alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        A = sc.next();
        B = sc.next();

        int [] list = new int [A.length() + B.length()];
        for (i = 0; i < A.length(); i++) {
            list[2 * i] = alphabet[A.charAt(i) - 'A'];
            list[2 * i + 1] = alphabet[B.charAt(i) - 'A'];
        }

        while(list.length > 2){
            int [] temp = new int [list.length - 1];

            for(i = 0; i < list.length - 1; i++){
                temp[i] = (list[i] + list[i + 1]) % 10;
            }

            list = temp;
        }

        System.out.println(list[0] + "" + list[1]);
    }
}
