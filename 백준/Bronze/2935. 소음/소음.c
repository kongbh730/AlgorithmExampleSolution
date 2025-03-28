#include <stdio.h>
#pragma warning(disable:4996)

int main(void) {
	char A[101] = "";
	char B[101] = "";
	char answer[202] = "";
	char oper;
	int i, A_length = 0, B_length = 0;

	scanf("%s", A);
	getchar();//입력버퍼 비우기
	scanf("%c", &oper);
	getchar();//입력버퍼 비우기
	scanf("%s", B);
	//printf("%s %c %s\n", A, oper, B);

	for (i = 0; i < 100; i++) {
		if (A[i] == '\0') {
			break;
		}
		A_length++;
	}
	for (i = 0; i < 100; i++) {
		if (B[i] == '\0') {
			break;
		}
		B_length++;
	}
	//printf("%d, %d\n", A_length, B_length);

	if (oper == '+') {
		if (A_length > B_length) {
			for (i = 0; i < A_length; i++) {
				answer[i] = A[i];
			}
			answer[A_length - B_length] = '1';
			answer[A_length] = '\0';
		}
		else if (A_length < B_length) {
			for (i = 0; i < B_length; i++) {
				answer[i] = B[i];
			}
			answer[B_length - A_length] = '1';
			answer[B_length] = '\0';
		}
		else if (A_length == B_length) {
			answer[0] = '2';
			for (i = 1; i < A_length; i++) {
				answer[i] = '0';
			}
			answer[A_length] = '\0';
		}
	}
	else if (oper == '*') {
		answer[0] = '1';
		for (i = 1; i < A_length + B_length - 1; i++) {
			answer[i] = '0';
		}
		answer[A_length + B_length - 1] = '\0';
	}
	printf("%s\n", answer);

	return 0;
}