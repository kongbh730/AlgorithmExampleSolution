import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [][] map;

    static class Location{
        int row;
        int col;

        Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());
    }

    public static void inputData(){
        int i, j;

        N = sc.nextInt();
        map = new int[N][N];

        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
    }

    public static String findAnswer(){
        int currentJellyRow = 0, currentJellyCol = 0;
        int nextJellyRow = 0, nextJellyCol = 0;
        int step;
        int i, j;

        //갈 수 있냐 없냐니까 DFS?
        //근데 아무리 커도 3*3이니까 브루트포스도 될 듯

        Stack<Location> st;
        st = new Stack<>();
        boolean [][] visited = new boolean[N][N];

        st.add(new Location(currentJellyRow, currentJellyCol));
        while(!st.isEmpty()){
            Location current = st.pop();
            currentJellyRow = current.row;
            currentJellyCol = current.col;
            visited[currentJellyRow][currentJellyCol] = true;

            if(currentJellyRow == N-1 && currentJellyCol == N-1){
                return "HaruHaru";
            }

            step = map[currentJellyRow][currentJellyCol];

            //오른쪽으로 가기
            if(currentJellyCol + step < N && !visited[currentJellyRow][currentJellyCol + step]){
                nextJellyRow = currentJellyRow;
                nextJellyCol = currentJellyCol + step;
                visited[nextJellyRow][nextJellyCol] = true;
                st.add(new Location(nextJellyRow, nextJellyCol));
            }

            //아래쪽으로 가기
            if(currentJellyRow + step < N && !visited[currentJellyRow + step][currentJellyCol]){
                nextJellyRow = currentJellyRow + step;
                nextJellyCol = currentJellyCol;
                visited[nextJellyRow][nextJellyCol] = true;
                st.add(new Location(nextJellyRow, nextJellyCol));
            }
        }

        return "Hing";
    }
}
