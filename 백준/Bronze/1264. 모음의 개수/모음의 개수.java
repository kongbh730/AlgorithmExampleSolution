import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int count = 0, i;

        while(true){
            count = 0;
            str = sc.nextLine();
            if(str.equals("#")){
                break;
            }

            str = str.toLowerCase();
            for(i = 0; i < str.length(); i++){
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
