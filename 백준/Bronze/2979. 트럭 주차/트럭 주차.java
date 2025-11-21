import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, B, C, i, j, sum = 0;
        int [][] parkingTime = new int[3][2];
        int [] time = new int[100];

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        for(i = 0; i < 3; i++){
            parkingTime[i][0] = sc.nextInt();
            parkingTime[i][1] = sc.nextInt();
        }
        sc.close();

        for(i = 0; i < 3; i++){
            for(j = parkingTime[i][0]; j < parkingTime[i][1]; j++){
                time[j]++;
            }
        }
//        for(int temp : time){
//            System.out.print(temp);
//        }

        for(i = 0; i < time.length; i++){
            if(time[i] == 1){
                sum += A;
            }
            else if(time[i] == 2){
                sum += B * 2;
            }
            else if(time[i] == 3){
                sum += C * 3;
            }
        }
        System.out.println(sum);
    }
}
