#include <stdio.h>
#pragma warning(disable:4996)

int find_answer(int N, int M, int K);

int main(void) {
	int N, M, K;

	scanf("%d %d %d", &N, &M, &K);
	printf("%d\n", find_answer(N, M, K));

	return 0;
}

int find_answer(int N, int M, int K) {
	int answer = 0;

	//N : 여학생
	//M : 남학생
	//K : 인턴쉽에 참여해야 하는 인원 -> 대회에 참여 못함
	//여학생 두명에 남학생 한명

	if (N / 2 <= M) {
		answer = N / 2;
	}
	else if (N / 2 > M) {
		answer = M;
	}

	K -= N + M - 3 * answer;
	if (K > 0) {
		K--;
		answer -= K / 3 + 1;
	}

	return answer;
}