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

	return;
}

void find_answer(int C, int R, int K) {
    int i, j;

    int** concert_stadium = (int**)malloc(R * sizeof(int*)); // R개의 행
    if (concert_stadium == NULL) {
        printf("메모리 할당 실패!\n");
        return;
    }

    for (i = 0; i < R; i++) {
        concert_stadium[i] = (int*)malloc(C * sizeof(int)); // 각 행마다 C개의 열 할당
        if (concert_stadium[i] == NULL) { // 할당 실패 시 이전 할당 메모리 해제
            for (j = 0; j < i; j++) {
                free(concert_stadium[j]);
            }
            free(concert_stadium);
            printf("메모리 할당 실패!\n");
            return;
        }
    }

    // 배열 초기화 (0으로 설정)
    for (i = 0; i < R; i++) {
        for (j = 0; j < C; j++) {
            concert_stadium[i][j] = 0;
        }
    }

    //문제에서는 시계방향이지만 배열 구조가 상하대칭이므로 반시계방향
    int direction = 0;//0이면 아래, 1이면 오른쪽, 2면 위, 3이면 왼쪽
    int current = 1;
    int x = 0, y = 0;
    int dx[4] = { 0, 1, 0, -1 };
    int dy[4] = { 1, 0, -1, 0 }; 

    if (K > C * R) {
        printf("0\n"); // K가 좌석보다 많으면 불가능
        return;
    }

    while (current <= K) {
        concert_stadium[y][x] = current; // 현재 위치에 숫자 배치

        if (current == K) { // K번째 위치 찾으면 출력
            printf("%d %d\n", x + 1, y + 1);
        }

        int nx = x + dx[direction]; // 다음 x 위치
        int ny = y + dy[direction]; // 다음 y 위치

        // 배열 범위를 벗어나거나 이미 숫자가 채워진 경우 → 방향 전환
        if (nx < 0 || nx >= C || ny < 0 || ny >= R || concert_stadium[ny][nx] != 0) {
            direction = (direction + 1) % 4; // 방향 변경
            nx = x + dx[direction];
            ny = y + dy[direction];
        }

        x = nx;
        y = ny;
        current++;
    }

    /*for (i = 0; i < R; i++) {
        for (j = 0; j < C; j++) {
            printf("%d ", concert_stadium[i][j]);
        }
        printf("\n");
    }*/

    // 메모리 해제
    for (i = 0; i < R; i++) {
        free(concert_stadium[i]);
    }
    free(concert_stadium);

    return;
}
