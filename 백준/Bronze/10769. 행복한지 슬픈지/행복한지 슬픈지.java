import java.util.Scanner;

public class Main {
    static String str = "";

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        sc.close();
    }

    public static void findAnswer(){
        int i = 0, happy = 0, sad = 0;

        while (i < str.length() - 2){
            if(str.charAt(i) == ':'){
                i++;
                if(str.charAt(i) == '-'){
                    i++;
                    if(str.charAt(i) == ')'){
                        happy++;
                    } else if (str.charAt(i) == '(') {
                        sad++;
                    }
                }
            }
            i++;
        }

        //System.out.println("happy : " + happy);
        //System.out.println("sad : " + sad);

        if(happy == 0 && sad == 0){
            System.out.println("none");
        }
        else if(happy > sad){
            System.out.println("happy");
        }
        else if(happy == sad){
            System.out.println("unsure");
        }
        else {
            System.out.println("sad");
        }
    }
}
