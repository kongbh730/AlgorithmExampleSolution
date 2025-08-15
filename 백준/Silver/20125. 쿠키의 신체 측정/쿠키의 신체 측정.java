import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char [][] map;
    static int N;
    static int heartX, heartY, hipY;

    public static void main(String[] args) throws IOException {
        inputData();
        findAnswer();
    }

//    public static void inputData(){
//        int i, j;
//        String temp;
//
//        N = sc.nextInt();
//        map = new char[N][N];
//
//        for(i = 0; i < N; i++){
//            temp = sc.next();
//            for(j = 0; j < N; j++){
//                map[i][j] = temp.charAt(j);
//            }
//        }
//
//        sc.close();
//    }

    public static void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 첫 줄: N
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine(); // 한 줄 읽기
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j); // 한 글자씩 저장
            }
        }
        br.close();
    }

    public static void findAnswer(){
        findHeart();
        findLeftArm();
        findRightArm();
        findWaist();
        findLeftLeg();
        findRightLeg();
    }

    public static void findHeart(){
        int i, j;

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                if(map[i][j] == '*'){
                    heartY = i + 1;
                    heartX = j;
                    System.out.println((heartY + 1) + " " + (heartX + 1));
                    return;
                }
            }
        }
    }

    public static void findLeftArm(){
        int i, length = 0;

        for(i = heartX - 1; i >= 0; i--){
            if(map[heartY][i] == '*'){
                length++;
            }
            else{
                break;
            }
        }
        System.out.print(length + " ");
    }

    public static void findRightArm(){
        int i, length = 0;

        for(i = heartX + 1; i < N; i++){
            if(map[heartY][i] == '*'){
                length++;
            }
            else{
                break;
            }
        }
        System.out.print(length + " ");
    }

    public static void findWaist(){
        int i, length = 0;

        for(i = heartY + 1; i < N; i++){
            if(map[i][heartX] == '*'){
                length++;
            }
            else{
                hipY = i - 1;
                break;
            }
        }
        System.out.print(length + " ");
    }

    public static void findLeftLeg(){
        int i, length = 0;

        for(i = hipY + 1; i < N; i++){
            if(map[i][heartX - 1] == '*'){
                length++;
            }
            else{
                break;
            }
        }
        System.out.print(length + " ");
    }

    public static void findRightLeg(){
        int i, length = 0;

        for(i = hipY + 1; i < N; i++){
            if(map[i][heartX + 1] == '*'){
                length++;
            }
            else{
                break;
            }
        }
        System.out.print(length + " ");
    }
}
