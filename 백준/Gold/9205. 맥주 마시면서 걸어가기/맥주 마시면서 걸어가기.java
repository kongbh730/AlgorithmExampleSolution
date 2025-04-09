import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        int distance(Point other){
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }

    static ArrayList<Point> locations;  // 0: 집, 1~N: 편의점, N+1: 페스티벌
    static boolean[] visited;

    public static void main(String[] args) {
        int t, i, j, N, x, y;

        t = sc.nextInt();
        for(i = 0; i < t; i++){
            N = sc.nextInt();
            locations = new ArrayList<>();

            // 집
            x = sc.nextInt();
            y = sc.nextInt();
            locations.add(new Point(x, y));

            // 편의점
            for(j = 0; j < N; j++){
                x = sc.nextInt();
                y = sc.nextInt();
                locations.add(new Point(x, y));
            }

            // 락 페스티벌
            x = sc.nextInt();
            y = sc.nextInt();
            locations.add(new Point(x, y));

            System.out.println(findAnswer());
        }

        sc.close();
    }

    public static String findAnswer(){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[locations.size()];
        int current, i;

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            current = q.poll();

            //current = q.peek();
            //q.remove();

            Point p = locations.get(current);

            if(current == locations.size() - 1){
                return "happy";
            }

            for(i = 0; i < locations.size(); i++){
                if(!visited[i] && p.distance(locations.get(i)) <= 1000){
                    visited[i] = true;
                    //System.out.println(locations.get(i).x + " " + locations.get(i).y);
                    q.add(i);
                }
            }
        }

        return "sad";
    }
}
