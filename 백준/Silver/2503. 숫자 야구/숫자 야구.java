import java.util.Scanner;

public class Main {
    static class Baseball {
        String numbers;
        int strike;
        int ball;

        Baseball(String numbers, int strike, int ball) {
            this.numbers = numbers;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static Baseball[] baseballs;

    public static void main(String[] args) {
        inputData();
        System.out.println(findAnswer());

        sc.close();
    }

    public static void inputData() {
        //System.out.println("inputData()");

        int N = sc.nextInt();
        int i;
        baseballs = new Baseball[N];

        for (i = 0; i < N; i++) {
            baseballs[i] = new Baseball(sc.next(), sc.nextInt(), sc.nextInt());
        }
    }

    public static int findAnswer() {
        //System.out.println("findAnswer()");

        int answer = 0;
        int i;
        int current;
        String youngsooNumbers, numbers;

        for (current = 100; current <= 999; current++) {
            youngsooNumbers = Integer.toString(current);//영수가 정답이라고 생각하는 숫자들

            // 중복된 숫자나 '0'이 포함된 경우 제외
            if (youngsooNumbers.charAt(0) == youngsooNumbers.charAt(1)
                    || youngsooNumbers.charAt(1) == youngsooNumbers.charAt(2)
                    || youngsooNumbers.charAt(2) == youngsooNumbers.charAt(0)
                    || youngsooNumbers.contains("0")) {
                continue;
            }


            boolean isValid = true;

            //부른 숫자들에 대해 전부 탐색
            for (Baseball baseball : baseballs) {
                int tempStrike = 0;
                int tempBall = 0;
                numbers = baseball.numbers;

                // 스트라이크 & 볼 판별
                for (i = 0; i < 3; i++) {
                    if (youngsooNumbers.charAt(i) == numbers.charAt(i)) {//위치와 값 모두 같음
                        tempStrike++;
                    } else if (numbers.contains(String.valueOf(youngsooNumbers.charAt(i)))) {
                        //numbers가 영수가 부른 숫자의 0,1,2인덱스의 수를 포함하면?
                        tempBall++;
                    }
                }

                // 조건을 만족하지 않으면 후보에서 제외
                if (tempStrike != baseball.strike || tempBall != baseball.ball) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                //System.out.println(youngsooNumbers);
                answer++;
            }
        }

        return answer;
    }
}