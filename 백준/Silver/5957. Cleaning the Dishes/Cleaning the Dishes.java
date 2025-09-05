import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Stack<Integer> Unwashed = new Stack<>();
    static Stack<Integer> WashedButNotDried = new Stack<>();
    static Stack<Integer> WashedAndDried = new Stack<>();
    static int N;
    static ArrayList<Integer> C = new ArrayList<>();
    static ArrayList<Integer> D = new ArrayList<>();

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        N = sc.nextInt();
        for(i = N; i > 0; i--){
            Unwashed.push(i);
        }
        while(sc.hasNext()){
            C.add(sc.nextInt());
            D.add(sc.nextInt());
        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j, c, d;

        for(i = 0; i < C.size(); i++){
            c = C.get(i);
            d = D.get(i);

            if(c == 1){// wash
                for(j = 0; j < d && !Unwashed.isEmpty(); j++){
                    WashedButNotDried.push(Unwashed.pop());
                }
            }
            else{//dry
                for(j = 0; j < d && !WashedButNotDried.isEmpty(); j++){
                    WashedAndDried.push(WashedButNotDried.pop());
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>(WashedAndDried);
        Collections.reverse(result);
        for (int dish : result) {
            System.out.println(dish);
        }
    }
}
