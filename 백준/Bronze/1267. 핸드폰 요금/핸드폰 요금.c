#include <stdio.h>
#pragma warning(disable:4996)

void input_time(int* N, int* time);
void find_answer(int N, int* time);

int main(void) {
	int N;
	int time[21];

	input_time(&N, time);
	find_answer(N, time);

	return 0;
}

void input_time(int* N, int* time) {
	int i;

	scanf("%d", N);
	for (i = 0; i < *N; i++)
	{
		scanf("%d", time + i);
	}

	/*for (i = 0; i < *N; i++) {
		printf("%d ", *(time + i));
	}*/

	return;
}

void find_answer(int N, int* time) {
	int Y_fee = 0, M_fee = 0;
	int i;

	for (i = 0; i < N; i++) {
		//영식 요금제 계산
		Y_fee += ((time[i] / 30) + 1) * 10;
		
		//민식 요금제 계산
		M_fee += ((time[i] / 60) + 1) * 15;
		//printf("time[%d] = %d : %d %d\n", i, time[i], Y_fee, M_fee);
	}

	if (Y_fee == M_fee) {
		printf("Y M %d\n", M_fee);
	}
	else if(Y_fee > M_fee){
		printf("M %d\n", M_fee);
	}
	else {
		printf("Y %d\n", Y_fee);
	}

	return;
}