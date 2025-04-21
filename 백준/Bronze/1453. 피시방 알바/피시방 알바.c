#include <stdio.h>
#include <stdbool.h>
#pragma warning(disable:4996)

int main(void) {
	bool seat[101] = { false };
	int N, s, i, count = 0;

	scanf("%d", &N);
	for (i = 0; i < N; i++) {
		scanf("%d", &s);
		if (seat[s] == false) {
			seat[s] = true;
		}
		else {
			count++;
		}
	}
	printf("%d\n", count);

	return 0;
}