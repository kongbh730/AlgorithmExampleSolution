import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean [] sw;
    static int [][] student;

    public static void main(String[] args) {
        inputData();
        findAnswer();

        sc.close();
    }

    public static void inputData() {
        int switchNum;
        int studentNum;
        int i;

        switchNum = sc.nextInt();
        sw = new boolean[switchNum + 1];
        for(i = 1; i <= switchNum; i++) {
            sw[i] = (sc.nextInt() == 1);
        }

        studentNum = sc.nextInt();
        student = new int[studentNum][2];
        for(i = 0; i < studentNum; i++) {
            student[i][0] = sc.nextInt();
            student[i][1] = sc.nextInt();
        }
    }

    public static void findAnswer() {
        //남학생은 스위치 번호가 자기가 받은 수의 배수이면 스위치 상태를 바꿈
        //여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
        //가장 많은 스위치를 포함하는 구간을 찾아서 그 구간에 속한 스위치의 상태를 모두 바꾼다.
        //이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
        //뭐라는 거야
        int i, j;
        int gender, swNum;

        for(i = 0; i < student.length; i++) {
            gender = student[i][0];
            swNum = student[i][1];

            if(gender == 1) {//남학생
                for(j = 1; j * swNum < sw.length; j++) {
                    sw[swNum * j] = !sw[swNum * j];
                }
            }
            else{//여학생
                sw[swNum] = !sw[swNum];
                j = 1;
                while(true){
                    if((swNum - j) < 1 || (swNum + j) > (sw.length - 1)) {
                        break;
                    }
                    else if(sw[swNum + j] == sw[swNum - j]){
                        sw[swNum + j] = !sw[swNum + j];
                        sw[swNum - j] = !sw[swNum - j];
                        j++;
                    }
                    else{
                        break;
                    }
                }
            }

//            for(j = 1; j < sw.length; j++) {
//                System.out.print(sw[j] + " ");
//            }
//            System.out.println();
        }
        
        //출력 부분에서 한 줄에 20개씩 출력임...
        for(j = 1; j < sw.length; j++) {
            System.out.print((sw[j] ? 1 : 0) + " ");
            if(j % 20 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }
}
