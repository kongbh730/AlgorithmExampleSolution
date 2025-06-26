import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Integer> trees = new HashMap<>();
    static int total = 0;

    public static void main(String[] args) {
        inputData();
        findAnswer();
        
        sc.close();
    }

    public static void inputData(){
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            trees.put(line, trees.getOrDefault(line, 0) + 1);
            total++;
        }
    }

    public static void findAnswer(){
        //자바는 c++과 달리 자료구조를 유지한채로 키값 기준 정렬이 불가능함
        ArrayList<String> names = new ArrayList<>(trees.keySet());
        Collections.sort(names);

        for (String key : names) {
            Integer value = trees.get(key);
            double rate = (double) value / total * 100;

            System.out.printf("%s %.4f%n", key, rate);
        }
    }
}

