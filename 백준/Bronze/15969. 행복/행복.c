#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int main(void) {
	int N, i;
	int score, maximum = -1, minimum = 1001;
	
	scanf("%d", &N);
	//arr를 동적 배열로 N 크기로 지정하고
	for (i = 0; i < N; i++) {
		scanf("%d", &score);

		if (score >= maximum) {
			maximum = score;
		}
		if (score <= minimum) {
			minimum = score;
		}
	}
	printf("%d\n", maximum - minimum);

	return 0;
}