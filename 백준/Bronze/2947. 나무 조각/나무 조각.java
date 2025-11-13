import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] piece = new int [5];
        int i, j, temp;

        for(i = 0; i < piece.length; i++){
            piece[i] = sc.nextInt();
        }
        sc.close();

        //버블정렬
        for(i = piece.length - 1; i >= 1; i--){
            for(j = 0; j < i; j++){
                if(piece[j] > piece[j + 1]){
                    temp = piece[j];
                    piece[j] = piece[j + 1];
                    piece[j + 1] = temp;
                    for(int num : piece){
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
