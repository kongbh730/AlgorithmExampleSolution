#include <stdio.h>
#pragma warning(disable:4996)

void input_data(int* arr, int* sum);
void find_answer(int* arr, int sum);

int main(void) {
	int arr[1001] = {0};
	int sum = 0;

	input_data(arr, &sum);
	find_answer(arr, sum);

	return 0;
}

void input_data(int *arr, int* sum) {
	int i, num;
	
	for (i = 0; i < 10; i++) {
		scanf("%d", &num);
		*sum += num;
		arr[num]++;
	}

	return;
}

void find_answer(int* arr, int sum) {
	int i, avg, freq = 0, max = 0;

	avg = sum / 10;
	for (i = 10; i <= 1000; i += 10) {
		//printf("%d ", arr[i]);
		if (arr[i] > max) {
			max = arr[i];
			freq = i;
		}
	}
	//printf("\n");
	printf("%d\n%d\n", avg, freq);

	return;
}