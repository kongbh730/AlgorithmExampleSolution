#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void input_data(vector < pair<pair<int, int>, vector<int>>> &buildings_info);
void find_answer(vector < pair<pair<int, int>, vector<int>>> &buildings_info);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	//진입 순서가 정해진 풀이의 경우 위상정렬 알고리즘 필요
	vector < pair<pair<int, int>, vector<int>>> buildings_info;
	//vector < pair<pair<건설 시간, 진입 차수>, vector<필요한 건물>>> buildings_info

	input_data(buildings_info);
	find_answer(buildings_info);

	return 0;
}

void input_data(vector < pair<pair<int, int>, vector<int>>> &buildings_info) {
	int i;
	int N, time, num = 0;

	cin >> N;
	buildings_info.resize(N + 1);
	for (i = 1; i <= N; i++) {

		cin >> time;
		buildings_info[i].first.first = time;
		while (1) {
			cin >> num;
			if (num == -1) {
				break;
			}
			buildings_info[num].second.push_back(i);
			buildings_info[i].first.second++;
		}
	}

	return;
}

void find_answer(vector < pair<pair<int, int>, vector<int>>>& buildings_info) {
	int i, time = 0, N = buildings_info.size() - 1;
	queue <int> q; // 위상정렬 알고리즘 사용
	vector<int> answer(N + 1, 0);
	int current_building;

	//for (i = 1; i < buildings_info.size(); i++) {
	//	cout << "건물 번호 : " << i;
	//	cout << " / 완성 필요 시간 : " << buildings_info[i].first.first;
	//	cout << " / 진입 차수 : " << buildings_info[i].first.second;
	//	cout << " / 전제 조건 건물 : ";
	//	for (int n : buildings_info[i].second) {
	//		cout << n << " ";
	//	}
	//	cout << "\n";
	//}

	//큐에 건물 건설 순서 저장
	for (i = 1; i <= N; i++) {
		if (buildings_info[i].first.second == 0) {//진입차수가 0 == 바로 건설 가능
			q.push(i);
			answer[i] = buildings_info[i].first.first;
		}
	}

	//완성되면 answer에 시간 저장하고, 큐에서 추출 반복
	while (!q.empty()) {
		current_building = q.front();
		q.pop();

		for (int next_building : buildings_info[current_building].second) {
			answer[next_building] 
				= max(answer[next_building], 
					answer[current_building] + buildings_info[next_building].first.first);
			buildings_info[next_building].first.second--;

			if (buildings_info[next_building].first.second == 0) {//진입차수가 0으로 떨어지면? -> 건설 가능
				q.push(next_building);
			}
		}
	}

	for (i = 1; i <= N; i++) {
		cout << answer[i] << "\n";
	}

	return;
}