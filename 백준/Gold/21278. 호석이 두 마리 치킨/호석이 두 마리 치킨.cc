#include <iostream>
#include <vector>
#include <algorithm>
#define INF 2100000000

using namespace std;

void input_data(int* N, int* M, vector<vector<int>>& road);
void find_answer(int N, int M, vector<vector<int>>& road);
void floyd_warshall(int N, vector<vector<int>>& road);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	vector<vector<int>> road;

	input_data(&N, &M, road);
	find_answer(N, M, road);

	return 0;
}

void input_data(int* N, int* M, vector<vector<int>>& road) {
	int i, A, B;
	
	cin >> *N >> * M;
	road.resize(*N + 1, vector<int>(*N + 1, INF));
	for (i = 0; i <= *N; i++) {
		road[i][i] = 0;
	}

	//양방향 그래프
	for (i = 0; i < *M; i++) {
		cin >> A >> B;
		road[A][B] = 1;
		road[B][A] = 1;
	}

	return;
}

void find_answer(int N, int M, vector<vector<int>>& road) {
	int A = 1, B = 1; // 치킨집을 지을 두 건물 위치
	int min_sum = INF, sum; // 모든 도시의 왕복 시간 총 합
	int i, j, k;

	floyd_warshall(N, road);
	for (i = 1; i <= N; i++) {
		for (j = i + 1; j <= N; j++) {
			sum = 0;
			for (k = 1; k <= N; k++) {
				if (k == i || k == j) {
					continue;
				}
				sum += min(road[k][i], road[k][j]) * 2;
			}

			if (sum < min_sum || (sum == min_sum && (i < A || (i == A && j < B)))) {
				min_sum = sum;
				A = i;
				B = j;
			}
		}
	}

	cout << A << " " <<  B << " " << min_sum << "\n";

	return;
}

void floyd_warshall(int N, vector<vector<int>>& road) {
	int i, j, k;

	/*
	cout << "플로이드 워셜 전\n";
	for (i = 0; i <= N; i++) {
		for (j = 0; j <= N; j++) {
			cout << road[i][j] << " ";
		}
		cout << "\n";
	}
	*/

	for (k = 1; k <= N; k++) {
		for (i = 1; i <= N; i++) {
			for (j = 1; j <= N; j++) {
				if (road[i][k] < INF && road[k][j] < INF) {
					road[i][j] = min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
	}

	/*
	cout << "플로이드 워셜 전\n";
	for (i = 0; i <= N; i++) {
		for (j = 0; j <= N; j++) {
			cout << road[i][j] << " ";
		}
		cout << "\n";
	}
	*/

	return;
}