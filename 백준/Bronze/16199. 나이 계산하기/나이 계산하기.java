import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int birthYear, birthMonth, birthDay;
        int baseYear, baseMonth, baseDay;
        int ManYear, CountingYear, Year;

        birthYear = sc.nextInt();
        birthMonth = sc.nextInt();
        birthDay = sc.nextInt();
        baseYear = sc.nextInt();
        baseMonth = sc.nextInt();
        baseDay = sc.nextInt();
        sc.close();
        
        Year = baseYear - birthYear;// 연 나이
        
        CountingYear = baseYear - birthYear + 1;// 세는 나이
        
        ManYear = Year;// 만 나이
        if (baseMonth < birthMonth || (baseMonth == birthMonth && baseDay < birthDay)) {
            ManYear--;
        }

        System.out.println(ManYear);
        System.out.println(CountingYear);
        System.out.println(Year);
    }
}
