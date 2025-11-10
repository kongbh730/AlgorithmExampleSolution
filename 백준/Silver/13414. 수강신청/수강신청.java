import java.util.*;

public class Main {
    static int K, L;
    static Set<String> queueSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        inputData();
        findAnswer();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        int i;
        String id;

        K = sc.nextInt();
        L = sc.nextInt();
        for (i = 0; i < L; i++) {
            id = sc.next();
            if (queueSet.contains(id)) {
                queueSet.remove(id);
            }
            queueSet.add(id);
        }

        sc.close();
    }

    public static void findAnswer(){
        int i = 0;

        for(String id : queueSet){
            System.out.println(id);
            i++;
            if(i == K){
                break;
            }
        }
    }
}
