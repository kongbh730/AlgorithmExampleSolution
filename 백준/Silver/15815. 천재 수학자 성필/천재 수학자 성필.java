import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //후위 표기법 : 피연산자를 먼저 표시하고 연산자를 나중에 표시하는 방법
        String statement = sc.next();
        System.out.println(findAnswer(statement));

        sc.close();
    }

    public static int findAnswer(String statement){
        //후위 표기법 : 피연산자를 먼저 표시하고 연산자를 나중에 표시하는 방법
        int answer = 0;
        int i, A, B, C;
        Stack<Integer> stack = new Stack<>();

        for(i = 0; i < statement.length(); i++){
            if(statement.charAt(i) == '+'){
                B = stack.pop();
                A = stack.pop();
                C = A + B;
                //System.out.println(C);
                stack.push(C);
            }
            else if(statement.charAt(i) == '-'){
                B = stack.pop();
                A = stack.pop();
                C = A - B;
                //System.out.println(C);
                stack.push(C);
            }
            else if(statement.charAt(i) == '*'){
                B = stack.pop();
                A = stack.pop();
                C = A * B;
                //System.out.println(C);
                stack.push(C);
            }
            else if(statement.charAt(i) == '/'){
                B = stack.pop();
                A = stack.pop();
                C = A / B;
                //System.out.println(C);
                stack.push(C);
            }
            else if(Character.isDigit(statement.charAt(i))){
                stack.push(Character.getNumericValue(statement.charAt(i)));
            }
            else{
                //사실 필요 없음...
            }
        }
        answer = stack.pop();

        return answer;
    }
}
