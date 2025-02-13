#include <stdio.h>

#pragma warning(disable:4996)

void input_data(int *N, int *M, int box[51][51]) {
	int i, j;
	char str[51];

	scanf("%d", N);
	scanf("%d", M);

	for (i = 0; i < *N; i++) {
		scanf("%s", str);
		for (j = 0; j < *M; j++) {
			box[i][j] = str[j] - '0';
		}
	}

	return;
}

int find_answer(int N, int M, int box[51][51]) {
	int i, j, k;
	int max = 1;
	int current_num, length, new_square;

	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			current_num = box[i][j];//현재 숫자
			//printf("(%d, %d) = %d\n", i, j, current_num);
			for (k = j + 1; k < M; k++) {
				if (current_num == box[i][k]) {//현재 숫자와 같은 숫자가 발견
					length = k - j;
					//printf("같은 숫자 찾음 : length = %d => ", length);
					if ((i + length < N) && (j + length < M) 
						&& current_num == box[i + length][j]
						&& current_num == box[i + length][j + length])
					{
						new_square = (length + 1) * (length + 1);
						if (max < new_square) {
							max = new_square;
						}
						//printf("현재 넓이 : %d", (length + 1) * (length + 1));
					}
					//printf("\n");
				}
			}
		}
	}

	return max;
}

int main(void) {
	int N, M;
	int box[51][51] = { 0 };

	input_data(&N, &M, box);
	printf("%d\n", find_answer(N, M, box));

	return 0;
}
