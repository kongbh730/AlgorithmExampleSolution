#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

void input_data(int* C, int* R, int* K);
void find_answer(int C, int R, int K);

int main(void) {
    int C, R, K;

    input_data(&C, &R, &K);
    find_answer(C, R, K);

    return 0;
}

void input_data(int* C, int* R, int* K) {
    scanf("%d %d %d", C, R, K);
}

void find_answer(int C, int R, int K) {
    if (K > C * R) {
        printf("0\n"); // 좌석 개수보다 크면 불가능
        return;
    }

    // 이동 방향 (아래 → 오른쪽 → 위 → 왼쪽)
    int dx[4] = { 0, 1, 0, -1 };
    int dy[4] = { 1, 0, -1, 0 };

    int x = 0, y = 0, direction = 0;
    int left = 0, right = C - 1, top = 0, bottom = R - 1;
    int current = 1;

    while (current < K) {
        // 다음 위치 계산
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        // 이동 불가능하면 방향 전환
        if (nx > right || nx < left || ny > bottom || ny < top) {
            if (direction == 0) { // 아래
                left++;
            }
            else if (direction == 1) { // 오른쪽
                bottom--;
            }
            else if (direction == 2) { // 위
                right--;
            }
            else { // 왼쪽
                top++;
            }
            direction = (direction + 1) % 4; // 방향 변경
            nx = x + dx[direction];
            ny = y + dy[direction];
        }

        x = nx;
        y = ny;
        current++;
    }

    printf("%d %d\n", x + 1, y + 1); // 1-based index로 출력
}
