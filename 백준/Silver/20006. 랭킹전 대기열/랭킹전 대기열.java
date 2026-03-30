import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class Player {
        int level;
        String nickname;
        
        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        int baseLevel; // 첫 입장자 레벨
        ArrayList<Player> players = new ArrayList<>();

        public Room(Player host) {
            this.baseLevel = host.level;
            players.add(host);
        }
    }

    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static int p, m;

    public static void main(String[] args) {
        inputData();
        matchRoom();
        printResult();
    }

    public static void inputData(){
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt(); // 플레이어 수
        m = sc.nextInt(); // 방 정원

        int i, l;
        String n;

        for(i = 0; i < p; i++){
            l = sc.nextInt();
            n = sc.next();

            players.add(new Player(l, n));
        }

        sc.close();
    }

    public static void matchRoom() {
        for (Player player : players) {
            boolean entered = false;

            for (Room room : rooms) {
                if (room.players.size() < m &&
                        player.level >= room.baseLevel - 10 &&
                        player.level <= room.baseLevel + 10) {
                    room.players.add(player);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                rooms.add(new Room(player));
            }
        }
    }

    public static void printResult(){
        int i, j;

        for(i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);

            room.players.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.nickname.compareTo(o2.nickname);
                }
            });

            if(rooms.get(i).players.size() == m){
                System.out.println("Started!");
            }
            else{
                System.out.println("Waiting!");
            }

            for(j = 0; j < rooms.get(i).players.size(); j++){
                System.out.println(rooms.get(i).players.get(j).level + " " + rooms.get(i).players.get(j).nickname);
            }
        }
    }
}
