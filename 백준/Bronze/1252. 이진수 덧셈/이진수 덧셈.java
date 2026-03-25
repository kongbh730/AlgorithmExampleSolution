import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bin1 = sc.next();
        String bin2 = sc.next();
        sc.close();

        int carry = 0, sum;
        StringBuilder sb = new StringBuilder();
        int bin1Length = bin1.length() - 1;
        int bin2Length = bin2.length() - 1;

        while(bin1Length >= 0 || bin2Length >= 0){
            sum = carry;

            if(bin1Length >= 0){
                sum += bin1.charAt(bin1Length) - '0';
            }
            if(bin2Length >= 0){
                sum += bin2.charAt(bin2Length) - '0';
            }

            bin1Length--;
            bin2Length--;

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0){
            sb.append(carry);
        }

        String result = sb.reverse().toString();
        result = result.replaceFirst("^0+", "");
        if(result.isEmpty()){
            result = "0";
        }

        System.out.println(result);
    }
}
