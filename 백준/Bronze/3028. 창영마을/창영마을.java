import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int i;
        boolean [] cups = {true, false, false};
        boolean temp;

        for(i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'A'){
                temp = cups[0];
                cups[0] = cups[1];
                cups[1] = temp;
            }
            else if(str.charAt(i) == 'B'){
                temp = cups[1];
                cups[1] = cups[2];
                cups[2] = temp;
            }
            else {
                temp = cups[0];
                cups[0] = cups[2];
                cups[2] = temp;
            }
        }

        for(i = 0; i < cups.length; i++){
            if(cups[i]){
                break;
            }
        }
        System.out.println(i+1);
    }
}
