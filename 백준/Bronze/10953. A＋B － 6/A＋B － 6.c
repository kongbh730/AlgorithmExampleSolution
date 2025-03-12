#include <stdio.h>
#pragma warning(disable:4996)

int main(void) {
	int n, i, A, B;
	char str[5];

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", str);
		A = str[0] - '0';
		B = str[2] - '0';
		printf("%d\n", A + B);
	}


	return 0;
}