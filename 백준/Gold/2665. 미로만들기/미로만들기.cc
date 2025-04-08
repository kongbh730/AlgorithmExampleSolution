#include <iostream>
#include <vector>
#include <deque>

using namespace std;

void input_data(int* N, vector<vector<int>> &graph);
int find_answer(int N, vector<vector<int>> &graph);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	vector<vector<int>> graph;

	input_data(&N, graph);
	cout << find_answer(N, graph) << "\n";

	return 0;
}

void input_data(int* N, vector<vector<int>>& graph) {
	int i, j;
	string temp;

	cin >> *N;
	graph.resize(*N, vector<int>(*N, 0));
	for (i = 0; i < *N; i++) {
		cin >> temp;
		for (j = 0; j < *N; j++) {
			graph[i][j] = temp[j] - '0';
		}
	}

	return;
}

int find_answer(int N, vector<vector<int>>& graph) {
    //BFS로 경로를 찾는데 0벽을 뚫은 횟수 더해서 최소로 벽뚫어서 도착하는 값 찾기

    vector<vector<int>> dist(N, vector<int>(N, 2100000000)); // 최소 벽 부순 횟수 저장
    deque<pair<int, int>> dq;
    vector<pair<int, int>> direction{ {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    int i, j;
    int current_x, current_y;
    int next_x, next_y;
    int cost;

    dq.push_back({ 0, 0 });
    dist[0][0] = 0;

    while (!dq.empty()) {
        current_x = dq.front().first;
        current_y = dq.front().second;
        dq.pop_front();

        for (i = 0; i < direction.size(); i++) {
            next_x = current_x + direction[i].first;
            next_y = current_y + direction[i].second;

            if ((next_x >= 0 && next_x < N) && (next_y >= 0 && next_y < N)) {
                // 다음 위치가 벽이면 비용 1, 빈 방이면 비용 0
                if (graph[next_y][next_x] == 0) {
                    cost = 1;
                }
                else {
                    cost = 0;
                }

                if (dist[next_y][next_x] > dist[current_y][current_x] + cost) {
                    dist[next_y][next_x] = dist[current_y][current_x] + cost;

                    if (cost == 0) {
                        dq.push_front({ next_x, next_y });
                    }
                    else {
                        dq.push_back({ next_x, next_y });
                    }
                }
            }
        }
    }

    return dist[N - 1][N - 1];
}
