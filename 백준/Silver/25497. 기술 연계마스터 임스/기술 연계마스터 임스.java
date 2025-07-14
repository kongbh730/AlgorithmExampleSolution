import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Queue<Character> skillQueue = new LinkedList<>();

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int N = sc.nextInt(), i;
        String skill = sc.next();

        for(i = 0; i < N; i++){
            skillQueue.add(skill.charAt(i));
        }

        sc.close();
    }

    public static int findAnswer(){
        int count = 0;
        Stack<Character> LR = new Stack<>();
        Stack<Character> SK = new Stack<>();

        /*
        * L은 R의 사전기술
        * S는 K의 사전기술
        * 사전 기술 없이 본 기술 사용하면 이후 기술 전부 중단
        * 사전 기술 사용했으면 본 기술은 중간에 다른 스킬이 포함되어 있어도 연계됨
        * */

        while(!skillQueue.isEmpty()){
            char currentSkill = skillQueue.poll();
            if(currentSkill - '0' >= 0 && currentSkill - '0' <= 9){
                count++;
                //System.out.println("숫자 스킬 연계");
            }
            else if(currentSkill == 'L'){
                LR.push('L');
            }
            else if(currentSkill == 'R'){
                if(!LR.isEmpty() && LR.peek() == 'L'){
                    LR.pop();
                    count++;
                    //System.out.println("LR 스킬 연계");
                }
                else{ // LR.isEmpty() || LR.peek() != 'L'
                    break;
                }
            }
            else if(currentSkill == 'S'){
                SK.push('S');
            }
            else if(currentSkill == 'K'){
                if(!SK.isEmpty() && SK.peek() == 'S'){
                    SK.pop();
                    count++;
                    //System.out.println("SK 스킬 연계");
                }
                else{ // !SK.isEmpty() && SK.peek() == 'S'
                    break;
                }
            }
        }

        return count;
    }
}
