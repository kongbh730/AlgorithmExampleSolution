import java.util.Scanner;

class num
{
    private int num;

    num()
    {
        num = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class combiNum
{
    private String num;

    combiNum()
    {
        num = "";
    }
    combiNum(int A, int B)
    {
        num = Integer.toString(A) + Integer.toString(B);
    }

    public long getNum() {
        return Long.parseLong(num);
    }

    public void setNum(int A, int B)
    {
        this.num = Integer.toString(A) + Integer.toString(B);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num A = new num();
        num B = new num();
        num C = new num();
        num D = new num();
        combiNum AB = new combiNum();
        combiNum CD = new combiNum();

        A.setNum(sc.nextInt());
        B.setNum(sc.nextInt());
        C.setNum(sc.nextInt());
        D.setNum(sc.nextInt());

        AB.setNum(A.getNum(), B.getNum());
        CD.setNum(C.getNum(), D.getNum());

        //1020 + 3040
        System.out.println(AB.getNum() + CD.getNum());
        

        sc.close();
    }
}
