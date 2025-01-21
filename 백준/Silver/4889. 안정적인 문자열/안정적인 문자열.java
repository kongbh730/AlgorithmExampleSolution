import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        int count = 1;

        while(true){
            input = sc.nextLine();
            if(input.contains("-")){//입력의 마지막 줄은 '-'가 한 개 이상 주어진다.
                break;
            }
            else{
                System.out.println(count + ". " + findAnswer(input));
                count++;
            }
        }
    }

    public static int findAnswer(String input){
        int answer = 0;
        int i;
        char ch1, ch2;

        Stack<Character> stack = new Stack<>();
        for(i = 0; i < input.length(); i++){
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
            }
            else if(!stack.isEmpty() && stack.peek() == '{'){//input.charAt[i] == '}'가 내포되어 있음
                stack.pop();
            }
            else{
                stack.push(input.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            ch1 = stack.pop();
            ch2 = stack.pop();

            if(ch1 == ch2){
                answer++;
            }
            else{//ch1 != ch2
                answer += 2;
            }
        }

        return answer;
    }
}
