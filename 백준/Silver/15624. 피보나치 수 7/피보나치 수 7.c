#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int main(void) {
	int n, i;
	int* DP;

	scanf("%d", &n);

	DP = (int*)malloc(sizeof(int) * (n + 1));// 배열을 힙 영역으로 이동
	if (DP == NULL) {
		fprintf(stderr, "메모리 할당 실패\n");
		return 1;
	}
	/*for (i = 0; i <= n; i++) {
		DP[i] = 0;
	}*/

	DP[0] = 0;
	DP[1] = 1;

	if (n >= 2) {
		for (i = 2; i <= n; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2]) % 1000000007;
			//printf("%d ", DP[i]);
		}
	}
	printf("%d\n", DP[n]);

	free(DP);

	return 0;
}
