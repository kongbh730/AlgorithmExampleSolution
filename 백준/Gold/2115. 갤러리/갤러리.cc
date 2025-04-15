#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

using namespace std;

void input_data(int* M, int* N, char*** gallery);
int find_answer(int M, int N, char** gallery);

int main(void) {
	int M, N; // M : 세로,  N : 가로
	char** gallery;
	
	input_data(&M, &N, &gallery);
	printf("%d\n", find_answer(M, N, gallery));

	// 메모리 해제
	for (int i = 0; i < M; i++) {
		free(gallery[i]);
	}
	free(gallery);

	return 0;
}

void input_data(int *M, int *N, char ***gallery) {
	int i, j;

	scanf("%d %d", M, N);
	*gallery = (char**)malloc(sizeof(char*) * (*M));
	for (i = 0; i < *M; i++) {
		(*gallery)[i] = (char*)malloc(sizeof(char) * (*N));// +1은 개행 처리
	}
	getchar();

	for (i = 0; i < *M; i++) {
		for (j = 0; j < *N; j++) {
			(*gallery)[i][j] = getchar();
		}
		getchar();
	}
	
	return;
}

int find_answer(int M, int N, char** gallery) {
	int answer = 0;
	int i, j;
	int length;
	//입력되는 모든 데이터에서 적어도 첫 줄과 마지막 줄, 첫 열과 마지막 열은 모두 벽이다.

	//가로로 길이가 2인 경우 찾기
	for (i = 0; i < M - 1; i++) {
		length = 1;
		for (j = 1; j < N; j++) {
			if (gallery[i][j - 1] == gallery[i][j] && //윗 부분이 벽이든 빈 공간이든 가로로 동일하다면 
				gallery[i + 1][j - 1] == gallery[i + 1][j]) {//아랫 부분이 벽이든 빈 공간이든 가로로 동일하다면
				length++;
			}
			else { // 윗 부분이나 아랫부분이 가로로 동일하지 않다면 == 연결이 끊김
				if (gallery[i][j - 1] != gallery[i + 1][j - 1]) { //윗 부분과 아랫부분의 구성요소가 다르다면? : 벽, 공간이라면?
					answer += length / 2;// 액자 추가
				}
				length = 1;
			}
		}
		//printf("%d행의 액자 결과 : %d\n", i, answer);
	}

	//세로로 길이가 2인 경우 찾기
	for (i = 0; i < N - 1; i++) {
		length = 1;
		for (j = 1; j < M; j++) {
			if (gallery[j - 1][i] == gallery[j][i] && //왼쪽 부분이 벽이든 빈 공간이든 세로로 동일하다면 
				gallery[j - 1][i + 1] == gallery[j][i + 1]) {//오른쪽 부분이 벽이든 빈 공간이든 세로로 동일하다면
				length++;
			}
			else { // 왼쪽 부분이나 오른쪽부분이 세로로 동일하지 않다면 == 연결이 끊김
				if (gallery[j - 1][i] != gallery[j - 1][i + 1]) { //왼쪽 부분과 오른쪽 부분의 구성요소가 다르다면? : 벽, 공간이라면?
					answer += length / 2;// 액자 추가
				}
				length = 1;
			}
		}
		//printf("%d열의 액자 결과 : %d\n", i, answer);
	}

	return answer;
}