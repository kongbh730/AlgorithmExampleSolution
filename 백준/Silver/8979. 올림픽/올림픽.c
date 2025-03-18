#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

typedef struct {
	int num;     // 국가 번호
	int gold;    // 금메달 개수
	int silver;  // 은메달 개수
	int bronze;  // 동메달 개수
} Country;

int main(void) {
	int N, K, i, rank = 1;
	Country medals[1001];
    Country target;

	scanf("%d %d", &N, &K);
    for (i = 0; i < N; i++) {
        scanf("%d %d %d %d", &medals[i].num, &medals[i].gold, &medals[i].silver, &medals[i].bronze);
        if (medals[i].num == K) {
            target = medals[i];
        }
    }

    for (i = 0; i < N; i++) {
        if (medals[i].num == K) {
            continue;
        }

        if (medals[i].gold > target.gold ||
            (medals[i].gold == target.gold && medals[i].silver > target.silver) ||
            (medals[i].gold == target.gold && medals[i].silver == target.silver && medals[i].bronze > target.bronze)) {
            rank++;
        }
    }

    printf("%d\n", rank);

    return 0;
}