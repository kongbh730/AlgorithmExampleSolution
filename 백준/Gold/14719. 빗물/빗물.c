#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

void input_data(int* H, int* W, int **blocks);
int find_answer(int H, int W, int* blocks);

int main(void) {
	int H, W;
	//int blocks[501];
	int* blocks;

	input_data(&H, &W, &blocks);
	printf("%d\n", find_answer(H, W, blocks));

	free(blocks);

	return 0;
}

void input_data(int* H, int* W, int** blocks) {
	int i;
	
	scanf("%d %d", H, W);

	*blocks = (int*)malloc((*W) * sizeof(int));
	if (*blocks == NULL) {
		fprintf(stderr, "Memory allocation failed\n");
		exit(1);
	}

	for (i = 0; i < *W; i++) {
		scanf("%d", &(*blocks)[i]);
	}

	return;
}

int find_answer(int H, int W, int* blocks) {
	int answer = 0;
	int left = 0, right = W - 1, minimum;
	int begin, end;

	while (left < right) {
		minimum = (blocks[left] < blocks[right]) ? blocks[left] : blocks[right];
		begin = left + 1;
		end = right;

		while (begin < end) {
			if (blocks[begin] < minimum) {
				answer += (minimum - blocks[begin]);
				blocks[begin] = minimum;
			}
			begin++;
		}
		if (minimum == blocks[left]) {
			left++;
		}
		else {
			right--;
		}
	}

	return answer;
}