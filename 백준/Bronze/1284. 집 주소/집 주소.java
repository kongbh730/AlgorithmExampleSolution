import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String N = sc.next();

            if(N.equals("0")){
                break;
            }
            System.out.println(findAnswer(N));
        }

        sc.close();
    }

    public static int findAnswer(String N){
        int i, len = 1;

        for(i = 0; i < N.length(); i++){
            if(N.charAt(i) == '1'){
                len += 2;
            }
            else if(N.charAt(i) == '0'){
                len += 4;
            }
            else{
                len += 3;
            }
            len++;
        }

        return len;
    }
}
