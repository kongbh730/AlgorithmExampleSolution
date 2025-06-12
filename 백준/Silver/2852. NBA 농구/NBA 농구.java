import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static String [] time;
    static int [] team;

    public static void main(String[] args) {
        inputData();
        findAnswer();

        sc.close();
    }

    public static void inputData(){
        int i;

        N = sc.nextInt();
        time = new String[N];
        team = new int[N];
        for(i = 0; i < N; i++){
            team[i] = sc.nextInt();
            time[i] = sc.next();
        }
    }

    public static void findAnswer(){
        int teamOneScore = 0, teamTwoScore = 0;
        int teamOneTime = 0, teamTwoTime = 0;
        int savedTime = 0; 
        int currentTime;

        for(int i = 0; i < N; i++){
            String[] temp = time[i].split(":");
            currentTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            
            if (teamOneScore > teamTwoScore) {
                teamOneTime += (currentTime - savedTime);
            } else if (teamTwoScore > teamOneScore) {
                teamTwoTime += (currentTime - savedTime);
            }
            
            if (team[i] == 1) {
                teamOneScore++;
            } else {
                teamTwoScore++;
            }

            savedTime = currentTime;
        }
        
        if (teamOneScore > teamTwoScore) {
            teamOneTime += (48 * 60 - savedTime);
        } else if (teamTwoScore > teamOneScore) {
            teamTwoTime += (48 * 60 - savedTime);
        }

        System.out.println(formatTime(teamOneTime));
        System.out.println(formatTime(teamTwoTime));
    }
    
    public static String formatTime(int seconds){
        int m = seconds / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d", m, s);
    }
}
