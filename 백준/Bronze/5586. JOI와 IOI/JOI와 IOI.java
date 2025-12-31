import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int i, JOICount = 0, IOICount = 0;

        str = sc.next();
        sc.close();
      
        for(i = 0; i < str.length() - 2; i++){
            if(str.charAt(i) == 'J' || str.charAt(i) == 'I'){
                if(str.startsWith("JOI", i)){
                    JOICount++;
                }
                else if(str.startsWith("IOI", i)){
                    IOICount++;
                }
            }
        }

        System.out.println(JOICount);
        System.out.println(IOICount);
    }
}
