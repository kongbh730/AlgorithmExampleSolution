#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void input_data(int* N, int* M, vector<vector<int>>& prior_question, vector<int> &input_degree);
void find_answer(int N, int M, vector<vector<int>>& prior_question, vector<int>& input_degree);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	vector<vector<int>> prior_question;
	vector<int> input_degree;

	input_data(&N, &M, prior_question, input_degree);
	find_answer(N, M, prior_question, input_degree);

	return 0;
}

void input_data(int* N, int* M, vector<vector<int>>& prior_question, vector<int>& input_degree) {
	int i, A, B;

	cin >> *N >> *M;
	prior_question.resize(*N + 1);
	input_degree.resize(*N + 1, 0);
	for (i = 0; i < *M; i++) {
		cin >> A >> B;
		prior_question[A].push_back(B);
		input_degree[B]++;
	}

	return;
}

void find_answer(int N, int M, vector<vector<int>>& prior_question, vector<int>& input_degree) {
	//queue<int> q;
	priority_queue<int, vector<int>, greater<int>> q;
	vector<int> answer;
	int i, current;

	for (i = 1; i <= N; i++) {
		if (input_degree[i] == 0) {
			q.push(i);
		}
	}

	while (!q.empty()) {
		//current = q.front();
		current = q.top();
		q.pop();
		answer.push_back(current);

		for (int next : prior_question[current]) {
			input_degree[next]--;
			if (input_degree[next] == 0) {
				q.push(next);
			}
		}
	}

	for (int num : answer) {
		cout << num << " ";
	}
	cout << "\n";

	return;
}