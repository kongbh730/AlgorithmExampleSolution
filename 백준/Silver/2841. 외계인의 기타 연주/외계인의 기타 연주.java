import java.util.*;

public class Main {
    static class Melody{
        int lineNum;
        int fretNum;
    }

    static Scanner scanner = new Scanner(System.in);
    static int N, P;
    static Queue<Melody> melodyQueue = new LinkedList<>();

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        scanner.close();
    }

    public static void inputData(){
        int i;

        N = scanner.nextInt();
        P = scanner.nextInt();
        for(i = 0; i < N; i++){
            Melody melody = new Melody();

            melody.lineNum = scanner.nextInt();
            melody.fretNum = scanner.nextInt();
            melodyQueue.offer(melody);
        }
    }

    public static int findAnswer(){
        int answer = 0;
        int nextLine, nextFret;
        int i;

        Stack<Integer>[] guitar = new Stack[7];
        for (i = 1; i <= 6; i++) {
            guitar[i] = new Stack<>();
        }

        while(!melodyQueue.isEmpty()){
            nextLine = melodyQueue.peek().lineNum;
            nextFret = melodyQueue.peek().fretNum;
            melodyQueue.poll();

            while (!guitar[nextLine].isEmpty() && guitar[nextLine].peek() > nextFret) {
                guitar[nextLine].pop();
                answer++;
            }

            if (!guitar[nextLine].isEmpty() && guitar[nextLine].peek() == nextFret) {
                continue;
            }

            guitar[nextLine].push(nextFret);
            answer++;
        }

        return answer;
    }
}
