import java.util.*;

public class Main {
    static class Log {
        int m;
        String problemName;
        String result;

        public Log(int m, String problemName, String result) {
            this.m = m;
            this.problemName = problemName;
            this.result = result;
        }
    }

    static ArrayList<Log> logs = new ArrayList<>();

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int m = sc.nextInt();
            if (m == -1) {
                break;
            }

            String problemName = sc.next();
            String result = sc.next();

            logs.add(new Log(m, problemName, result));
        }

        sc.close();
    }

    public static void findAnswer() {
        HashMap<String, Integer> wrongCount = new HashMap<>();
        HashSet<String> solved = new HashSet<>();
        int correct = 0, totalTime = 0;

        for (Log log : logs) {
            String name = log.problemName;
            
            if (solved.contains(name)) {
                continue;
            }

            if (log.result.equals("right")) {
                correct++;
                totalTime += log.m + wrongCount.getOrDefault(name, 0) * 20;
                solved.add(name);
            } else if (log.result.equals("wrong")) {
                wrongCount.put(name, wrongCount.getOrDefault(name, 0) + 1);
            }
        }

        System.out.println(correct + " " + totalTime);
    }
}
