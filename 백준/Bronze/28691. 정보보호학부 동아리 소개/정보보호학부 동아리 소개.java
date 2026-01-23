import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ch = sc.next();
        sc.close();
        
        if(ch.equals("M")){
            System.out.println("MatKor");
        }
        else if(ch.equals("W")){
            System.out.println("WiCys");
        }
        else if(ch.equals("C")){
            System.out.println("CyKor");
        }
        else if(ch.equals("A")){
            System.out.println("AlKor");
        }
        else if(ch.equals("$")){
            System.out.println("$clear");
        }
    }
}
