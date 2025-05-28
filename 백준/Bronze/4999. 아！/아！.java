import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String JaehwanStr = sc.nextLine();
        String DoctorStr = sc.nextLine();

        if(JaehwanStr.length() >= DoctorStr.length()) {
            System.out.println("go");
        }
        else{
            System.out.println("no");
        }

        sc.close();
    }
}
