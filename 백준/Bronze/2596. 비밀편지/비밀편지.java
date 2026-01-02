import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, i, j, order, k = 0;
        String str;
        StringBuilder answer = new StringBuilder();
        boolean flag = true; 

        N = sc.nextInt();
        str = sc.next();
        sc.close();

        String[] crypt = {"000000", "001111","010011","011100","100110","101001","110101","111010"};

        for (i = 0; i < N; i++) {
            order = i * 6;
            String temp = str.substring(order, order + 6);

            boolean find = false;

            for (j = 0; j < crypt.length; j++) {
                int diff = 0;

                for (int t = 0; t < 6; t++) {
                    if (temp.charAt(t) != crypt[j].charAt(t)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }

                if (diff <= 1) { 
                    answer.append((char) ('A' + j));
                    find = true;

                    break;
                }
            }

            if (!find) {
                flag = false;
                k = i + 1;

                break;
            }
        }

        if (flag) {
            System.out.println(answer);
        } else {
            System.out.println(k);
        }
    }
}
