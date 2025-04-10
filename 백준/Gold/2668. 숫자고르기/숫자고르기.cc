#include <iostream>
#include <vector>
#include <stack>

using namespace std;

void input_data(vector<int>& table);
void find_answer(vector<int>& table);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> table;

	input_data(table);
	find_answer(table);

	return 0;
}

void input_data(vector<int> &table) {
	int N, i;

	cin >> N;
	table.resize(N + 1);
	for (i = 1; i <= N; i++) {
		cin >> table[i];
	}

	return;
}

void find_answer(vector<int>& table) {
	vector<int> result;
	int i, j, N = table.size() - 1, current, next;
	
	//DFS인거 같은데
	for (i = 1; i <= N; i++) {
		vector<bool> visited(N + 1, false);
		stack <int> st;
		st.push(i);

		while (!st.empty()) {
			current = st.top();
			st.pop();

			if (visited[current]) {//방문한 적 있다면?
				continue;
			}
			
			visited[current] = true;
			next = table[current];
			if (next == i) {
				result.push_back(i);
				break;
			}

			if (!visited[next]) {//방문한 적 없다면?
				st.push(next);
			}
		}
	}

	cout << result.size() << "\n";
	for (int num : result) {
		cout << num << "\n";
	}

	return;
}
