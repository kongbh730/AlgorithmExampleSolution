import java.util.Scanner;

public class Main {
    static String [] texts;

    public static void main(String[] args) {
        inputData();
        print();
    }

    public static void inputData(){
        int N, i;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        texts = new String[N];
        sc.nextLine();
        for(i = 0; i < N; i++){
            texts[i] = sc.nextLine();
        }

        sc.close();
    }

    public static void print(){
        int i;

        for(i = 0; i < texts.length; i++){
            System.out.println(i+1 + ". " + texts[i]);
        }
    }
}
