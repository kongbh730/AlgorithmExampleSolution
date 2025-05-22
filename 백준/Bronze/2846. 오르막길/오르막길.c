#include <stdio.h>
#pragma warning(disable:4996)

void input_data(int* N, int* height);
int find_answer(int N, int* height);

int main(void) {
	int N;
	int height[1001];

	input_data(&N, height);
	printf("%d\n", find_answer(N, height));


	return 0;
}

void input_data(int* N, int* height) {
	int i;

	scanf("%d", N);
	for (i = 0; i < *N; i++) {
		scanf("%d", height + i);
	}

	return;
}

int find_answer(int N, int* height) {
	int answer = 0, count, max;
	int i, j;

	count = 0;
	max = 0;
	for (i = 1; i < N; i++) {
		if (height[i - 1] < height[i]) {
			count += (height[i] - height[i-1]);
		}
		else {
			max = ((max < count) ? count : max);
			//printf("max : %d\n", max);
			count = 0;
		}
	}
	max = ((max < count) ? count : max);
	//printf("max : %d\n", max);
	answer = max;

	return answer;
}