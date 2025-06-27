import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] testCase;

    public static void main(String[] args) {
        inputData();
        findAnswer();
        
        sc.close();
    }

    public static void inputData(){
        int T, i;

        T = sc.nextInt();
        testCase = new int[T];
        for(i = 0; i < testCase.length; i++){
            testCase[i] = sc.nextInt();
        }
    }

    public static void findAnswer(){
        int i, index, temp, current;
        ArrayList <Integer> f = new ArrayList<>();

        //피보나치 수열 저장
        f.add(0);
        f.add(1);
        index = 2;
        while(true){
            temp = f.get(index - 2) + f.get(index - 1);
            if(temp > 1000000000){
                break;
            }
            f.add(temp);
            //System.out.print(temp + " ");
            index++;
        }
        //System.out.println();

        // 테스트케이스 풀이
        for(i = 0; i < testCase.length; i++){
            current = testCase[i];
            index = f.size() - 1;
            ArrayList<Integer> greedyFibo = new ArrayList<>();

            while(current != 0){
                if(f.get(index) > current){
                    ;
                }
                else if(f.get(index) == current){
                    greedyFibo.add(f.get(index));
                    break;
                }
                else{ //f.get(index) < current
                    greedyFibo.add(f.get(index));
                    current -= f.get(index);
                }
                index--;
            }

            Collections.sort(greedyFibo);
            for(int ans : greedyFibo){
                System.out.print(ans + " ");
            }

            System.out.println();
        }
    }
}
