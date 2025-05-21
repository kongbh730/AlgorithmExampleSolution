import java.util.Scanner;

public class Main {
    static class Location{
        private int direction;
        private int distance;

        public Location(int direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
    static Scanner sc = new Scanner(System.in);
    static Location dongguen;
    static Location[] stores;
    static int width, height;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        int N, i;
        int direction, distance;

        width = sc.nextInt();
        height = sc.nextInt();
        N = sc.nextInt();

        stores = new Location[N];
        for(i = 0; i < N; i++) {
            direction = sc.nextInt();
            distance = sc.nextInt();
            Location store = new Location(0, 0);
            store.setDirection(direction);
            store.setDistance(distance);

            stores[i] = store;
        }

        direction = sc.nextInt();
        distance = sc.nextInt();
        dongguen = new Location(0, 0);
        dongguen.setDirection(direction);
        dongguen.setDistance(distance);
    }

    public static int findAnswer() {
        int answer = 0;
        int i;
        int total_length = (width + height) * 2;
        int dongguen_location = findLocation(dongguen.getDirection(), dongguen.getDistance());
        //System.out.println("total_length : " + total_length);
        //System.out.println("dongguen_location : " + dongguen_location);

        for(i = 0; i < stores.length; i++) {
            int store_location = findLocation(stores[i].getDirection(), stores[i].getDistance());
            //System.out.println("store_location : " + store_location);
            int clockwise = Math.abs(dongguen_location - store_location);
            int counterClockwise = total_length - clockwise;

            int temp = Math.min(clockwise, counterClockwise);
            //System.out.println("temp : " + temp);
            answer += temp;
        }

        return answer;
    }

    public static int findLocation(int direction, int distance) {
        int location;

        //북 - 동 - 남 - 서 순으로 사각형을 직선으로 편다고 생각
        if(direction == 1) {//북
            location = distance;
        }
        else if(direction == 2) {//남
            location = (width - distance) + width + height;
        }
        else if(direction == 3) {//서
            location = (height - distance) + width + height + width;
        }
        else {//동
            location = distance + width;
        }

        return location;
    }
}
