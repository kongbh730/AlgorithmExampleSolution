#include <stdio.h>
#include <stdbool.h>
#pragma warning (disable:4996)

void input_data(int* N, int* M, int *r, int *c, int* direction, int room[51][51]);
int find_answer(int N, int M, int r, int c, int direction, int room[51][51]);

int main(void) {
	int N, M;
	int r, c, direction;
	int room[51][51];
	
	input_data(&N, &M, &r, &c, &direction, room);
	printf("%d\n", find_answer(N, M, r, c, direction, room));

	return 0;
}

void input_data(int* N, int* M, int* r, int* c, int* direction, int room[51][51]) {
	int i, j;
	
	scanf("%d %d", N, M);
	scanf("%d %d %d", r, c, direction);//y값, x값
	for (i = 0; i < *N; i++) {
		for (j = 0; j < *M; j++) {
			scanf("%d", &room[i][j]);//0이면 먼지 있음, 1이면 벽
		}
	}

	return;
}

int find_answer(int N, int M, int r, int c, int direction, int room[51][51]) {
	int count = 0, i;
	int current_y = r, current_x = c, next_x, next_y, current_direction = direction;
	int dir[4][2] = { {0, -1},{1, 0}, {0, 1}, {-1, 0} };//북, 동, 남, 서
	bool stop = false, find;

	while(!stop){
		if (room[current_y][current_x] == 0) {
			count++;
			room[current_y][current_x] = -1;//현재 칸 청소
			//printf("현재 칸 청소\n");
			//printf("현재 상태 (%d, %d -> %d) : %d\n", current_x, current_y, current_direction, count);
		}

		//주변 4칸 중 청소되지 않은 빈칸 찾기
		find = false;
		for (i = 0; i < 4; i++) {
			next_x = current_x + dir[i][0];
			next_y = current_y + dir[i][1];

			if (room[next_y][next_x] == 0 
				&& (next_x >= 0 && next_x < M) 
				&& (next_y >= 0 && next_y < N)) {//먼지 찾음
				find = true;
				//printf("주변 4칸 중 먼지 있음\n");
				break;
			}
		}

		if (find) {//주변 4칸 중 청소되지 않은 빈칸 찾음
			//반시계 방향 90도 회전
			//printf("회전 %d -> ", current_direction);
			current_direction = (current_direction + 3) % 4;
			//printf("%d\n", current_direction);
			//바라보는 방향 기준 앞쪽 칸이 청소되지 않은 칸인 경우 한칸 이동
			//printf("(%d, %d) -> ", current_x, current_y);
			if (room[current_y + dir[current_direction][1]][current_x + dir[current_direction][0]] == 0) {
				//printf("(%d, %d) -> ", current_x, current_y);
				current_x = current_x + dir[current_direction][0];
				current_y = current_y + dir[current_direction][1];
				//printf("(%d, %d)\n", current_x, current_y);
			}
			//아니면 다시 순회
			else {
				;
			}
		}
		else {//주변 4칸 중 청소되지 않은 빈칸 없음
			//후진 계산
			if (current_direction == 0) {//북쪽방향 본 상태로 후진->남쪽 이동
				current_y += 1;
			}
			else if (current_direction == 1) {//동쪽방향 본 상태로 후진->서쪽 이동
				current_x -= 1;
			}
			else if (current_direction == 2) {//남쪽방향 본 상태로 후진->북쪽 이동
				current_y -= 1;
			}
			else {//current_direction == 3//서쪽방향 본 상태로 후진->동쪽 이동
				current_x += 1;
			}
			
			//방향 유지한 채로 후진 가능하면 후진
			if ((current_x >= 0 && current_x < M) && (current_y >= 0 && current_y < N) && room[current_y][current_x] != 1) {
				continue;
			}
			//바라보는 방향 뒤쪽 칸이 벽이라 후진 불가능하면 정지
			else {
				stop = true;
			}
		}
	}

	return count;
}