#include <stdio.h>
#pragma warning(disable:4996)

int main(void) {
	int N, M;
	char castle[51][51];
	char str[52];
	int i, j, answerRow = 0, answerCol = 0;

	scanf("%d %d", &N, &M);
	for (i = 0; i < N; i++) {
		scanf("%s", &str);
		for (j = 0; j < M; j++) {
			castle[i][j] = str[j];
		}
	}

	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			if (castle[i][j] == 'X') {
				break;
			}
			else {
				;
			}
		}
		if (j == M) {
			answerRow++;
		}
	}

	for (j = 0; j < M; j++) {
		for (i = 0; i < N; i++) {
			if (castle[i][j] == 'X') {
				break;
			}
			else {
				;
			}
		}
		if (i == N) {
			answerCol++;
		}
	}
	//printf("%d %d\n", answerRow, answerCol);
	printf("%d\n", (answerRow > answerCol) ? answerRow : answerCol);

	return 0;
}