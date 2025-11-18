import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cambridge = "CAMBRIDGE";
        String str;
        int i, j;

        str = sc.next();
        sc.close();

        for(i = 0; i < str.length(); i++){
            boolean find = false;
            for(j = 0; j < cambridge.length(); j++){
                if(str.charAt(i) == cambridge.charAt(j)){
                    find = true;
                    break;
                }
            }
            if(!find){
                System.out.print(str.charAt(i));
            }
        }
    }
}
