import java.util.Scanner;

public class Main {
    static int N, M;
    static int [] weights;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;

        N = sc.nextInt();
        M = sc.nextInt();
        weights = new int[N];
        for(i = 0; i < N; i++){
            weights[i] = sc.nextInt();
        }
        sc.close();
    }

    public static int findAnswer(){
        if(N == 0){
            return 0;
        }

        int answer = 1;
        int weight = M - weights[0];
        int i;
        
        for(i = 1; i < N; i++){
            if(weight - weights[i] >= 0){
                weight = weight - weights[i];
            }
            else{//weight - weights[i] < 0
                answer++;
                weight = M - weights[i];
            }
        }

        return answer;
    }
}
