#include <stdio.h>
#pragma warning(disable:4996)

void input_data(int* P_x, int* P_y) {
	scanf("%d %d", P_x, P_y);
	//printf("%d %d\n", *P_x, *P_y);

	return;
}

int find_answer(int P1_x, int P1_y, int P2_x, int P2_y, int P3_x, int P3_y) {
	//시계방향, 반시계방향인지 구분하려면?
	//시계방향?
	//두 기울기가 다르고 변곡점 존재,

	//일직선?
	//두 기울기가 동일함

	//반시계방향?
	//두 기울기가 다르고 변곡점 존재,

	int cross = (P2_x - P1_x) * (P3_y - P2_y) - (P2_y - P1_y) * (P3_x - P2_x);

	if (cross > 0) { // 반시계 방향
		return 1;
	}  
	if (cross < 0) {  // 시계 방향
		return -1;
	}
    return 0;  // 일직선               
}

int main(void) {
	int P1_x, P1_y;
	int P2_x, P2_y;
	int P3_x, P3_y;

	input_data(&P1_x, &P1_y);
	input_data(&P2_x, &P2_y);
	input_data(&P3_x, &P3_y);
	printf("%d\n", find_answer(P1_x, P1_y, P2_x, P2_y, P3_x, P3_y));
	return 0;
}