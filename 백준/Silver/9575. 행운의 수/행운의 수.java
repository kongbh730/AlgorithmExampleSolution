import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] A;
    static int[] B;
    static int[] C;

    public static void main(String[] args) {
        int T = sc.nextInt();
        int i;

        for(i = 0; i < T; i++){
            inputData();
            System.out.println(findAnswer());
        }

        sc.close();
    }

    public static void inputData(){
        int N, M, K;
        int i;

        N = sc.nextInt();
        A = new int[N];
        for(i = 0; i < A.length; i++){
            A[i] = sc.nextInt();
        }

        M = sc.nextInt();
        B = new int[M];
        for(i = 0; i < B.length; i++){
            B[i] = sc.nextInt();
        }

        K = sc.nextInt();
        C = new int[K];
        for(i = 0; i < C.length; i++){
            C[i] = sc.nextInt();
        }
    }

    public static int findAnswer(){
        int i, j, k,l, sum = 0;
        String temp;
        Set<Integer> set = new HashSet<>();

        for(i = 0; i < A.length; i++){
            for(j = 0; j < B.length; j++){
                for(k = 0; k < C.length; k++){
                    sum = A[i] + B[j] + C[k];

                    //temp = String.valueOf(sum);
                    temp = Integer.toString(sum);

                    for(l = 0; l < temp.length(); l++){
                        if(temp.charAt(l) != '5' && temp.charAt(l) != '8'){
                            break;
                        }
                    }

                    if(l == temp.length()){
                        set.add(sum);
                    }
                }
            }
        }

        return set.size();
    }
}
