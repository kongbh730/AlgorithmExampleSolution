import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int [] order;
    static class Frame {
        int studentNum;
        int time;
        int recommendation;

        Frame(int studentNum, int time, int recommendation) {
            this.studentNum = studentNum;
            this.time = time;
            this.recommendation = recommendation;
        }
    }

    public static void main(String[] args) {
        inputData();
        findAnswer();

        sc.close();
    }

    public static void inputData(){
        int i;
        int size;

        N = sc.nextInt();
        size = sc.nextInt();
        order = new int[size];
        for(i = 0; i < size; i++){
            order[i] = sc.nextInt();
        }
    }

    public static void findAnswer(){
        int i, j, current, minFrameNum, minRecommentdation, frameIndex;
        Frame [] frames = new Frame[N];
        for(i = 0; i < frames.length; i++){
            frames[i] = new Frame(0,0, 0);
        }

        for(i = 0; i < order.length; i++){
            current = order[i];

            // 이미 지금 액자 속에 있는지 또는 빈 공간이 있는지 확인
            boolean isEmpty = false;
            boolean isInFrames = false;
            minFrameNum = frames.length;
            for(j = 0; j < frames.length; j++){
                if(current == frames[j].studentNum){// 이미 액자 속에 있음
                    isInFrames = true;
                    break;
                }
                if(frames[j].studentNum == 0){//빈 공간 발견
                    isEmpty = true;
                    if(j < minFrameNum){
                        minFrameNum = j;
                    }
                }
            }

            if(isInFrames){//이미 액자 속에 존재함
                frames[j].recommendation++;
            }
            else{//액자 속에 존재 안함
                if(isEmpty){//액자에 새로 사진 삽입할 빈 공간이 존재함
                    frames[minFrameNum].studentNum = current;
                    frames[minFrameNum].time = 0;
                    frames[minFrameNum].recommendation = 1;
                }
                else{//액자에 새로 사진 삽입할 빈 공간이 없음
                    //가장 추천수가 적은 번호 찾기
                    //만약 추천수가 같다면 가장 오래된 번호 찾기
                    minRecommentdation = 1000;
                    frameIndex = 0;

                    for(j = 0; j < N; j++){
                        if(frames[j].recommendation <= minRecommentdation){
                            if(frames[j].recommendation < minRecommentdation){
                                minRecommentdation = frames[j].recommendation;
                                frameIndex = j;
                            }
                            else{//추천수가 같다면
                                if(frames[j].time > frames[frameIndex].time){//더 오래된 번호 선택
                                    frameIndex = j;
                                }
                            }
                        }
                    }
                    frames[frameIndex].studentNum = current;
                    frames[frameIndex].time = 0;
                    frames[frameIndex].recommendation = 1;
                }
            }

            //모든 액자의 경과 시간 증가
            for(j = 0; j < frames.length; j++){
                frames[j].time++;
            }
        }

//        for(Frame temp : frames){
//            System.out.println(temp.studentNum + "번 , " + temp.recommendation + "번 추천, " + temp.time + "경과");
//        }

        int [] answer = new int[frames.length];

        for(i = 0; i < frames.length; i++){
            answer[i] = frames[i].studentNum;
        }
        Arrays.sort(answer);
        for(int num : answer){
            if(num != 0){// 액자가 널널해서 빈칸이 많이 남아있을 수도 있음
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
