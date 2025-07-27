import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] array = new int[5];

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i;

        for(i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }

        sc.close();
    }

    public static int findAnswer(){
        int num = 1;
        int i, count;

        while(true){
            count = 0;
            for(i = 0; i < array.length; i++){
                if(num % array[i] == 0){
                    count++;
                }
            }
            if(count >= 3){
                break;
            }
            num++;
        }

        return num;
    }
}
