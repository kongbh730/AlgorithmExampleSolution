import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String name;
    static String [] teamNames;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int N, i;

        name = sc.next();
        N = sc.nextInt();
        teamNames = new String[N];
        for(i = 0; i < N; i++){
            teamNames[i] = sc.next();
        }

//        System.out.println(name);
//        System.out.println(N);
//        for(String temp : teamNames){
//            System.out.println(temp);
//        }

        sc.close();
    }

    public static String findAnswer(){
        String answer = "";
        int N = teamNames.length;
        int i, j;
        int baseL = 0, baseO = 0, baseV = 0, baseE = 0;
        int maxScore = -1;

        Arrays.sort(teamNames);

        for (i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'L'){
                baseL++;
            }
            else if (c == 'O') {
                baseO++;
            }
            else if (c == 'V') {
                baseV++;
            }
            else if (c == 'E'){
                baseE++;
            }
        }

        for (i = 0; i < N; i++) {
            String t = teamNames[i];
            int addL = 0, addO = 0, addV = 0, addE = 0;

            for (j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                if (c == 'L'){
                    addL++;
                }
                else if (c == 'O') {
                    addO++;
                }
                else if (c == 'V') {
                    addV++;
                }
                else if (c == 'E') {
                    addE++;
                }
            }

            int L = baseL + addL;
            int O = baseO + addO;
            int V = baseV + addV;
            int E = baseE + addE;

            long score = (long) (L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E) % 100;

            if (score > maxScore) {
                maxScore = (int)score;
                answer = t;
            }
        }
        return answer;
    }
}
