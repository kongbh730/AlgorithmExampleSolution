import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //중복되는 숫자가 없으면 1개로 합체 가능
        //중복되는 숫자가 있고, 개수가 2개라면 2개로 합체
        //중복되는 숫자가 있고, 개수가 3개라면 3개로 합체???

        int [] arr;
        int N, i, maxLength, currentLength;

        N = sc.nextInt();
        arr = new int[N];
        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        maxLength = 1;
        currentLength = 1;
        for(i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                currentLength++;
                if(maxLength <  currentLength){
                    maxLength = currentLength;
                }
            }
            else{
                currentLength = 1;
            }
        }

        System.out.println(maxLength);

        sc.close();
    }
}
