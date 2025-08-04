import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Integer> students = new HashMap<>();

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        int N = sc.nextInt();
        sc.nextLine(); // 개행 제거

        String[] names = sc.nextLine().split(" ");
        for(String name : names){
            students.put(name, 0);
        }

        for(int i = 0; i < N; i++){
            String[] votes = sc.nextLine().split(" ");
            for(String name : votes){
                students.put(name, students.get(name) + 1);
            }
        }
    }

    public static void findAnswer(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(students.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 내림차순
            } else {
                return a.getKey().compareTo(b.getKey()); // 사전순 오름차순
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
