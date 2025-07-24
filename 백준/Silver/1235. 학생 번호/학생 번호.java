import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String [] strings;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;

        strings = new String[sc.nextInt()];
        for(i = 0; i < strings.length; i++){
            strings[i] = sc.next();
        }
    }

    public static int findAnswer() {
        int len = strings[0].length();

        for (int k = 1; k <= len; k++) {
            Set<String> set = new HashSet<>();

            for (String s : strings) {
                set.add(s.substring(len - k));
            }
            
            if (set.size() == strings.length) {
                return k;
            }
        }

        return len;
    }
}
