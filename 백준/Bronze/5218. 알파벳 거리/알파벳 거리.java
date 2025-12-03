import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> solveAlphabetDistance(String s1, String s2) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        /* ------------------- INSERT CODE HERE ---------------------*/

        int temp = 0, j;

        for(j = 0; j < s1.length(); j++){
            int x = s1.charAt(j) - 'A';
            int y = s2.charAt(j) - 'A';

            if(y >= x){
                temp = y - x;
            }
            else{
                temp = y + 26 - x;
            }

            answer.add(temp);	// add x to ArrayList<Integer> answer
        }


        /* -------------------- END OF INSERTION --------------------*/

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++)
        {
            String s1 = sc.next();
            String s2 = sc.next();

            ArrayList<Integer> answer = solveAlphabetDistance(s1, s2);
            System.out.print("Distances: ");

            for(Integer d : answer) {
                System.out.print(d+" ");
            }
            System.out.println();

        }
    }
}


/*

import java.util.Scanner;

public class Main {
    static String [][] testcases;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i, testcase;

        testcase = sc.nextInt();
        sc.nextLine();  //버퍼비우기
        testcases = new String[testcase][2];
        for(i = 0; i < testcases.length; i++){
            testcases[i] = sc.nextLine().split(" ");
        }

//        for(String [] strs : testcases){
//            for(String str : strs){
//                System.out.print(str + " ");
//            }
//            System.out.println();
//        }

        sc.close();
    }

    public static void findAnswer(){
        int i, j;

        for(i = 0; i < testcases.length; i++){
            System.out.print("Distances: ");
            for(j = 0; j < testcases[i][0].length(); j++){
                int x = testcases[i][0].charAt(j) - 'A';
                int y = testcases[i][1].charAt(j) - 'A';

                if(y >= x){
                    System.out.print(y - x + " ");
                }
                else{
                    System.out.print(y + 26 - x + " ");
                }
            }
            System.out.println();
        }
    }
}
*/
