import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int i, j;

        for(i = 0; i < 3; i++){
            String str = sc.next();
            int continuousLength = 1, maxContinuousLength = 1;

            for(j = 1; j < 8; j++){
                if(str.charAt(j) == str.charAt(j - 1)){
                    continuousLength++;
                }
                else{
                    maxContinuousLength = Math.max(maxContinuousLength, continuousLength);
                    continuousLength = 1;
                }
            }
            maxContinuousLength = Math.max(maxContinuousLength, continuousLength);

            System.out.println(maxContinuousLength);
        }

        sc.close();
    }
}
