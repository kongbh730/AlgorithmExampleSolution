#include <stdio.h>
#pragma warning(disable:4996)

int main(void) {
	int n, i, Chang = 100, Jung = 100, C_dice, J_dice;

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d %d", &C_dice, &J_dice);

		if (C_dice > J_dice) {
			Jung -= C_dice;
		}
		else if (C_dice == J_dice) {
			continue;
		}
		else if (C_dice < J_dice) {
			Chang -= J_dice;
		}

		//printf("%d %d\n", Chang, Jung);
	}
	printf("%d\n%d\n", Chang, Jung);

	return 0;
}