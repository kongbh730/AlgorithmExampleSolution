#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int main(void) {
	int A, B, C;
	char strA[20], strB[20], AB[40];

	scanf("%d %d %d", &A, &B, &C);

	sprintf(strA, "%d", A);
	sprintf(strB, "%d", B);
	strcpy(AB, strA);
	strcat(AB, strB);

	int AB_num = atoi(AB);

	printf("%d\n", A + B - C); 
	printf("%d\n", AB_num - C); 

	return 0;
}