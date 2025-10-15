import java.util.Scanner;

public class Main {
    static double [][] grade;

    public static void main(String[] args) {
        inputData();
        System.out.printf("%.2f\n", findAnswer());
    }

    public static void inputData(){
        int N, i;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();// 버퍼 비우기
        grade = new double[N][2];
        for(i = 0; i < N; i++){
            String [] str = sc.nextLine().split(" ");
            grade[i][0] = Integer.parseInt(str[1]);
            grade[i][1] = str[2].equals("A+") ? 4.3 :
            str[2].equals("A0") ? 4.0 :
            str[2].equals("A-") ? 3.7 :
            str[2].equals("B+") ? 3.3 :
            str[2].equals("B0") ? 3.0 :
            str[2].equals("B-") ? 2.7 :
            str[2].equals("C+") ? 2.3 :
            str[2].equals("C0") ? 2.0 :
            str[2].equals("C-") ? 1.7 :
            str[2].equals("D+") ? 1.3 :
            str[2].equals("D0") ? 1.0 :
            str[2].equals("D-") ? 0.7 : 0.0;
        }

        sc.close();
    }

    public static double findAnswer(){
        double sum = 0;
        double total = 0;
        int i;

        for(i = 0; i < grade.length; i++){
            total += grade[i][0];
            sum += grade[i][0] * grade[i][1];
        }

        return Math.round((sum / total) * 100.0) / 100.0;
    }
}
