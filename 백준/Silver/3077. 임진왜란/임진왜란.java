import java.util.*;

public class Main {
    static String [] battles;
    static String [] answers;

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int N;

        N = sc.nextInt();
        sc.nextLine();//개행문자 비우기
        battles = sc.nextLine().split(" ");
        answers = sc.nextLine().split(" ");

        sc.close();
    }

    public static void findAnswer(){
        int N = answers.length, i, j;

        Map<String, Integer> order = new HashMap<>();
        for (i = 0; i < N; i++) {
            order.put(battles[i], i);
        }

        Queue<Integer> q = new LinkedList<>();
        for (i = 0; i < N; i++) {
            q.add(order.get(answers[i]));
        }

        long score = 0;
        List<Integer> list = new ArrayList<>(q); 
        for (i = 0; i < N; i++) {
            for (j = i + 1; j < N; j++) {
                if (list.get(i) < list.get(j)) {
                    score++;
                }
            }
        }

        long total = (long) N * (N - 1) / 2;
        System.out.println(score + "/" + total);
    }
}
