import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String [] words;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int N, i;
        char[] word;

        N = sc.nextInt();
        words = new String[N];
        for(i = 0; i < N; i++){
            word = sc.next().toCharArray();
            //System.out.print(Arrays.toString(word) + " -> ");
            Arrays.sort(word);
            //System.out.println(Arrays.toString(word));
            words[i] = Arrays.toString(word);
        }

        sc.close();
    }

    public static int findAnswer(){
        int i;
        Set<String> list = new HashSet<>();

        for(i = 0; i < words.length; i++){
            list.add(words[i]);
        }

//        for(String temp : list){
//            System.out.println(temp);
//        }

        return list.size();
    }
}
