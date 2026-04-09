import java.util.Scanner;

public class Main {
    static class Result{
        private int result = 0;

        public void add(int num){
            result += num;
        }

        public void subtract(int num){
            result -= num;
        }

        public void multiply(int num){
            result *= num;
        }

        public void divide(int num){
            result /= num;
        }
        
        public int getResult(){
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Result result = new Result();
        String str;

        result.add(Integer.parseInt(sc.next()));
        while(true){
            str = sc.next();
            
            if(str.equals("=")){
                System.out.println(result.getResult());
                break;
            }
            else if(str.equals("+")){
                result.add(Integer.parseInt(sc.next()));
            }
            else if(str.equals("-")){
                result.subtract(Integer.parseInt(sc.next()));
            }
            else if(str.equals("*")){
                result.multiply(Integer.parseInt(sc.next()));
            }
            else if(str.equals("/")){
                result.divide(Integer.parseInt(sc.next()));
            }
        }

        sc.close();
    }
}
