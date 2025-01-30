import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] parent;
    static int N;
    static int one, two;

    public static void main(String[] args) {
        int T, i;

        T = sc.nextInt();
        for (i = 0; i < T; i++) {
            inputData();
            System.out.println(findAnswer());
        }

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");
        int i, A, B;

        N = sc.nextInt();
        parent = new int[N + 1];
        for(i = 0; i < N - 1; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            //B의 부모는 A다
            parent[B] = A;
        }
        one = sc.nextInt();
        two = sc.nextInt();

//        System.out.println("입력결과");
//        for(int num : parent) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");
        int answer = 0;
        boolean [] visited = new boolean[N + 1];

        //one를 루트까지 이동
        //System.out.println("one을 루트까지 이동");
        while(one > 0){
            visited[one] = true;
            //System.out.print(one + "의 부모 노드 ");
            one = parent[one];
            //System.out.println(one);
        }

        //two를 루트 노드로 이동하는데 이미 방문한 적 있는 노드에 방문하면 그게 공통조상
        //System.out.println("\ntwo를 루트까지 이동");
        while(two > 0){
            if(visited[two]){
                //System.out.println("공통조상 만남 : " + two);
                answer = two;
                break;
            }
            //System.out.print(two + "의 부모 노드 ");
            visited[two] = true;
            two = parent[two];
            //System.out.println(two);
        }

        return answer;
    }
}
