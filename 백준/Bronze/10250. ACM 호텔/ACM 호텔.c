#include <stdio.h>
#pragma warning (disable:4996)

void input_data(int* H, int* W, int* N);
int find_answer(int H, int W, int N);

int main(void) {
	int T;
	int H, W, N;

	scanf("%d", &T);
	while (T--) {
		input_data(&H, &W, &N);
		printf("%d\n", find_answer(H, W, N));
	}

	return 0;
}

void input_data(int* H, int* W, int* N) {
	//printf("input_data()\n");

	scanf("%d", H);
	scanf("%d", W);
	scanf("%d", N);

	return;
}

int find_answer(int H, int W, int N) {
	int answer = 0;
	//printf("%d %d %d\n", H, W, N);
	/*높이 H, 넓이 W인 호텔에서 101, 201, 301...이런식으로 N번째 손님은 어느 방에 입실?*/
	int floor, room, temp;
	
	temp = N % H;
	if (temp == 0) {
		floor = H;
		room = N / H;
	}
	else {
		floor = N % H;
		room = N / H + 1;
	}

	answer = floor * 100 + room;

	return answer;
}