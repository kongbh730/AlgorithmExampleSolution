import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int i, j;

        for(i = 0; i < T; i++){
            String number = sc.next();

            int [] count = new int[10];

            for(j = 0; j < number.length(); j++){
                count[number.charAt(j)-'0']++;
            }

            int countNum = 0;
            for(j = 0; j < count.length; j++){
                if(count[j] > 0){
                    countNum++;
                }
            }

            System.out.println(countNum);
        }

        sc.close();
    }
}
