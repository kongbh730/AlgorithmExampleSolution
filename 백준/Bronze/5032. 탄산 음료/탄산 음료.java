import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f, e, c;
        int remain = 0, sum = 0;

        e = sc.nextInt();//가지고 있는 빈 병
        f = sc.nextInt();//그날 발견한 빈 병
        c = sc.nextInt();//새 병으로 바꾸는데 필요한 빈 병

        sc.close();

        remain = f + e;
        while(remain >= c){
            sum += (remain / c);
            remain = (remain / c) + (remain % c);

            //System.out.println("sum : "+ sum);
            //System.out.println("remain : " + remain);
        }

        System.out.println(sum);
    }
}
