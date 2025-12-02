import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] cards = {0, 1,2,3,4,5,6,7,8,9,10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int i, j, a, b, temp;

        for(i = 0; i < 10; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            for(j = 0; j <= (b-a)/2; j++){
                temp = cards[a+j];
                cards[a+j]= cards[b-j];
                cards[b-j] = temp;
            }

//            for(int num : cards){
//                System.out.print(num + " ");
//            }
//            System.out.println();
        }

        for(i = 1; i < cards.length; i++){
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
}
