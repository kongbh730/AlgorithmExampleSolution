import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startH,startM,startS, endH, endM, endS;
        int h, m, s;

        for(int i = 0; i < 3; i++){
            startH = sc.nextInt();
            startM = sc.nextInt();
            startS = sc.nextInt();
            endH = sc.nextInt();
            endM = sc.nextInt();
            endS = sc.nextInt();

            h = endH - startH;
            m = endM - startM;
            s = endS - startS;

            if(s < 0){
                s += 60;
                m -= 1;
            }
            if(m < 0){
                m += 60;
                h -= 1;
            }

            System.out.println(h + " " + m + " " + s);
        }
        sc.close();
    }
}
