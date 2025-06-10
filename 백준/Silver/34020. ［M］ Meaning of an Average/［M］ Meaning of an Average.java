import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] list;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData(){
        int N, i;

        N = sc.nextInt();
        list = new int[N];

        for(i = 0; i < N; i++){
            list[i] = sc.nextInt();
        }
    }

    public static double findAnswer(){
        double answer = 0;

        Arrays.sort(list);

        double temp;
        int i;

        temp = list[0];
        for(i = 1; i < list.length; i++){
            temp = (temp + list[i]) / 2;
        }
        answer = temp;

        return answer;
    }
}
