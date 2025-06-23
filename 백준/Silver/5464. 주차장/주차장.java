import java.util.*;

public class Main {
    static class ParkingLot{
        int parkingSpaceNum;
        int currentCarNum;
        int fee;

        ParkingLot (int parkingSpaceNum, int currentCarNum, int fee){
            this.parkingSpaceNum = parkingSpaceNum;
            this.currentCarNum = currentCarNum;
            this.fee = fee;
        }
    }

    static class Car{
        int carNum;
        int weight;

        Car(int carNum, int weight){
            this.carNum = carNum;
            this.weight = weight;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static ParkingLot [] parkingLots;
    static Car [] cars;
    static int [] inOut;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData(){
        int i, s, W;

        N = sc.nextInt();
        M = sc.nextInt();

        parkingLots = new ParkingLot[N];
        for(i = 0; i < parkingLots.length; i++){//주차 공간들의 단위 무게당 요금
            s = sc.nextInt();
            parkingLots[i] = new ParkingLot(i + 1, 0, s);
        }

        cars = new Car[M];
        for(i = 0; i < cars.length; i++){
            W = sc.nextInt();
            cars[i] = new Car(i+1, W);
        }

        inOut = new int[2*M];
        for(i = 0; i < inOut.length; i++){
            inOut[i] = sc.nextInt();
        }
    }

    public static int findAnswer(){
        int costSum = 0, i, j, currentCar;
        Queue<Integer> waitingQueue = new LinkedList<>();

        for(i = 0; i < inOut.length; i++){
            currentCar = inOut[i];

            if(currentCar > 0){//차가 들어와야 하는 경우
                //System.out.println(currentCar + "번 차 들어옴");
                for(j = 0; j < parkingLots.length; j++){
                    if(parkingLots[j].currentCarNum == 0){// 빈 공간 찾음
                        parkingLots[j].currentCarNum = currentCar;//해당 공간에 삽입
                        //System.out.println(parkingLots[j].parkingSpaceNum + "에 " + parkingLots[j].currentCarNum + "번 차 삽입");
                        costSum += (parkingLots[j].fee * cars[currentCar - 1].weight);
                        break;
                    }
                }
                if(j == parkingLots.length){// 빈 공간 못 찾음
                    //System.out.println("빈 공간 없음, 대기열에 삽입");
                    waitingQueue.offer(currentCar);//대기열에 삽입
                }
            }
            else{//차가 나가야 하는 경우
                //System.out.println(currentCar + "번 차 나감");
                for(j = 0; j < parkingLots.length; j++){
                    if(parkingLots[j].currentCarNum == -currentCar){
                        parkingLots[j].currentCarNum = 0;//해당 주차장에서 나가기
                        break;
                    }
                }
                if(!waitingQueue.isEmpty()){
                    parkingLots[j].currentCarNum = waitingQueue.poll();
                    //System.out.println(parkingLots[j].parkingSpaceNum + "에 대기열에서" + parkingLots[j].currentCarNum + "번 차 삽입");
                    costSum += (parkingLots[j].fee * cars[parkingLots[j].currentCarNum - 1].weight);
                }
            }
        }

        return costSum;
    }
}
