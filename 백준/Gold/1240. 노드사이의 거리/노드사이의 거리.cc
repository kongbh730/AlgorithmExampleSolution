#include <iostream>
#include <vector>
#include <stack>

using namespace std;

void input_data(int *N, int *M, vector<vector<pair<int, int>>> &node, vector<vector<int>>& which_length_need_to_know) {
	int i, j;
	int A, B, len;

	cin >> *N >> *M;
	node.resize(*N + 1);
	for (i = 0; i < *N - 1; i++) {
		cin >> A >> B >> len;
		node[A].push_back({ B, len });
		node[B].push_back({ A, len });
	}
	for (i = 0; i < *M; i++) {
		cin >> A >> B;
		which_length_need_to_know.push_back({ A, B });
	}

	return;
}

int dfs(int start, int destination, vector<vector<pair<int, int>>>& node) {
	int i;
	stack <pair<int, int>> st;

	int current_node, next_node;
	int current_len = 0, next_len = 0;
	vector<bool> visited(node.size());

	st.push({ start, 0 });
	while (!st.empty()) {
		current_node = st.top().first;
		current_len = st.top().second;
		st.pop();

		if (current_node == destination) {
			return current_len;
		}

		for (i = 0; i < node[current_node].size(); i++) {
			next_node = node[current_node][i].first;
			if (!visited[next_node]) {
				next_len = current_len + node[current_node][i].second;
				st.push({ next_node, next_len });
				visited[next_node] = true;
			}
		}
	}
}


void find_answer(int N, int M, vector<vector<pair<int, int>>>& node, vector<vector<int>>& which_length_need_to_know) {
	int i, j;
	int start, destination;

	/*
	for (i = 1; i <= N; i++) {
		for (j = 0; j < node[i].size(); j++) {
			cout << "(" << i << ", " << node[i][j].first << " : " << node[i][j].second << ") ";
		}
		cout << "\n";
	}
	*/

	for (i = 0; i < M; i++) {
		start = which_length_need_to_know[i][0];
		destination = which_length_need_to_know[i][1];

		//cout << "start : " << start << " destination : " << destination << "\n";
		
		cout << dfs(start, destination, node) << "\n";
	}

	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	vector<vector<pair<int, int>>> node;
	vector<vector<int>> which_length_need_to_know;

	input_data(&N, &M, node, which_length_need_to_know);
	find_answer(N, M, node, which_length_need_to_know);

	return 0;
}