#include <stdio.h>
#pragma warning(disable:4996)

int main(void) {
	long long A, B;

	scanf("%lld %lld", &A, &B);
	printf("%lld\n", (A + B) * (A - B));

	return 0;
}