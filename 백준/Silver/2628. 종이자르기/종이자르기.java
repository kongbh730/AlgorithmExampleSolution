import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static int x, y;
    static ArrayList<Integer> xCutting = new ArrayList<Integer>();
    static ArrayList<Integer> yCutting = new ArrayList<Integer>();

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        int n, i, direction, point;
        x = sc.nextInt();
        y = sc.nextInt();

        xCutting.add(x);
        yCutting.add(y);
        xCutting.add(0);
        yCutting.add(0);

        n = sc.nextInt();
        for(i = 0; i < n; i++) {
            direction = sc.nextInt();
            point = sc.nextInt();

            if(direction == 1) {
                xCutting.add(point);
            }
            else{
                yCutting.add(point);
            }
        }
    }

    public static int findAnswer() {
        int answer = 0, i;
        int maxX = 0, maxY = 0;

        Collections.sort(xCutting);
        Collections.sort(yCutting);

        /*
        System.out.print("xCutting : ");
        for(int temp : xCutting) {
            System.out.print(temp + " ");
        }
        System.out.print("\nyCutting : ");
        for(int temp : yCutting) {
            System.out.print(temp + " ");
        }
        System.out.println();
        */

        for(i = 1; i < xCutting.size(); i++) {
            maxX = Math.max(maxX, xCutting.get(i) - xCutting.get(i - 1));
        }
        for(i = 1; i < yCutting.size(); i++) {
            maxY = Math.max(maxY, yCutting.get(i) - yCutting.get(i - 1));
        }
        //System.out.println("maxX : " + maxX + ", maxY : " + maxY);
        answer = maxX * maxY;

        return answer;
    }
}
