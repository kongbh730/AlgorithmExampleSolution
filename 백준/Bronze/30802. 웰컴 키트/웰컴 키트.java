import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int T, P, N;
    static int [] size = new int[6];

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int i;

        N = scanner.nextInt();//참가자 수
        for(i = 0; i < size.length; i++){
            size[i] = scanner.nextInt();//사이즈 별 신청자 수
        }
        T = scanner.nextInt(); // 티셔츠 묶음 수
        P = scanner.nextInt(); // 펜 묶음 수
    }

    public static void findAnswer(){
        int TShirts = 0;
        int i;

        for(i = 0; i < size.length; i++){
            if(size[i] == 0){
                TShirts += 0;
            }
            else if(size[i] % T == 0){
                TShirts += size[i] / T;
            }
            else{
                TShirts += size[i] / T + 1;
            }
        }
        System.out.println(TShirts);
        System.out.println((N / P) + " " + (N % P));
    }
}
