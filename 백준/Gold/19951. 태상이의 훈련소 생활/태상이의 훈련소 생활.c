//#include <stdio.h>
//#include <stdlib.h>
//#pragma warning(disable:4996)
//
//void input_data(int* N, int* M);
//int* input_ground(int N);
//int** input_order(int M);
//int* input_order2(int N, int M);
//void find_answer(int N, int M, int* ground, int** order);
//void find_answer2(int N, int M, int* ground, int* order);
//
//int main(void) {
//	int N, M;
//	int* ground;
//	int** order;
//	int* order2;
//
//	input_data(&N, &M);
//	ground = input_ground(N);
//	//order = input_order(M);
//	order2 = input_order2(N, M);
//
//	//find_answer(N, M, ground, order);
//	find_answer2(N, M, ground, order2);
//
//	// 메모리 해제
//	free(ground);
//	/*for (int i = 0; i < M; i++) {
//		free(order[i]);
//	}
//	free(order);*/
//	free(order2);
//
//	return 0;
//}
//
//void input_data(int* N, int* M) {
//	scanf("%d %d", N, M);
//
//	return;
//}
//
//int *input_ground(int N) {
//	int i;
//	int* ground = (int*)malloc(sizeof(int) * (N + 1));
//
//	if (ground == NULL) {
//		fprintf(stderr, "메모리 할당 실패\n");
//		exit(1);
//	}
//
//	for (i = 1; i <= N; i++) {
//		scanf("%d", &ground[i]);
//	}
//
//	return ground;
//}
//
//int** input_order(int M) {
//	int i, a, b, k;
//	int** order = (int**)malloc(sizeof(int*) * M);
//	if (order == NULL) {
//		fprintf(stderr, "메모리 할당 실패\n");
//		exit(1);
//	}
//
//	for (i = 0; i < M; i++) {
//		order[i] = (int*)malloc(sizeof(int) * 3);
//		if (order[i] == NULL) {
//			fprintf(stderr, "메모리 할당 실패\n");
//			exit(1);
//		}
//
//		scanf("%d %d %d", &a, &b, &k);
//		order[i][0] = a;
//		order[i][1] = b;
//		order[i][2] = k;
//	}
//
//	return order;
//}
//
//int* input_order2(int N, int M) {
//	int i, j, a, b, k;
//	int* order2 = (int*)malloc(sizeof(int) * (N + 1));
//
//	if (order2 == NULL) {
//		fprintf(stderr, "메모리 할당 실패\n");
//		exit(1);
//	}
//	for (i = 0; i <= N; i++) {
//		order2[i] = 0;
//	}
//
//	for (i = 0; i < M; i++) {
//		scanf("%d %d %d", &a, &b, &k);
//		for (j = a; j <= b; j++) {
//			order2[j] += k;
//		}
//	}
//
//	return order2;
//}
//
//
////시간 초과 발생 -> 입력과 동시에 명령을 하나로 묶어?야함
//void find_answer(int N, int M, int* ground, int** order) {
//	int i, j, a, b, k;
//	
//	for (i = 0; i < M; i++) {
//		a = order[i][0];
//		b = order[i][1];
//		k = order[i][2];
//		for (j = a; j <= b; j++) {
//			ground[j] += k;
//		}
//		/*
//		for (j = 1; j <= N; j++) {
//			printf("%d ", ground[j]);
//		}
//		printf("\n");
//		*/
//	}
//
//	for (j = 1; j <= N; j++) {
//		printf("%d ", ground[j]);
//	}
//	printf("\n");
//
//	return;
//}
//
//// 시간 초과 발생 또
//void find_answer2(int N, int M, int* ground, int* order) {
//	int i;
//
//	for (i = 1; i <= N; i++) {
//		ground[i] += order[i];
//		printf("%d ", ground[i]);
//	}
//	printf("\n");
//
//	return;
//}

#include <stdio.h>
#pragma warning(disable:4996);
#define MAXN 100001

void input_data(int* N, int* M, int* ground) {
    scanf("%d %d", N, M);
    for (int i = 1; i <= *N; i++) {
        scanf("%d", &ground[i]);
    }
}

void process_orders(int M, int* diff) {
    int a, b, k;
    for (int i = 0; i < M; i++) {
        scanf("%d %d %d", &a, &b, &k);
        diff[a] += k;
        diff[b + 1] -= k;
    }
}

void apply_and_print_result(int N, int* ground, int* diff) {
    int sum = 0;
    for (int i = 1; i <= N; i++) {
        sum += diff[i];
        ground[i] += sum;
        printf("%d ", ground[i]);
    }
    printf("\n");
}

int main(void) {
    int N, M;
    int ground[MAXN] = { 0 };
    int diff[MAXN] = { 0 };

    input_data(&N, &M, ground);
    process_orders(M, diff);
    apply_and_print_result(N, ground, diff);

    return 0;
}
