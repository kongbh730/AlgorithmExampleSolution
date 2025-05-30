import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        for(char c : str.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                System.out.print(c);
            }
        }

        sc.close();
    }
}
