#include <iostream>
#include <vector>

using namespace std;

void input_data(vector<int>& T);
void find_answer(vector<int>& T);
long long DFS(int W, int H, vector<vector<long long>>& DP);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> T;

	input_data(T);
	find_answer(T);

	return 0;
}

void input_data(vector<int> &T) {
	int test_case = 0;

	while (1) {
		cin >> test_case;
		if (test_case == 0) {
			break;
		}
		T.push_back(test_case);
	}

	return;
}

void find_answer(vector<int>& T) {
	int i, W, H;
	vector<vector<long long>> DP(31, vector<long long>(31, 0));

	for (i = 0; i < T.size(); i++) {
		W = T[i];
		cout << DFS(W, 0, DP) << "\n";
	}

	return;
}

long long DFS(int W, int H, vector<vector<long long>> &DP) {
	if (H == -1) {
		return 0;
	}
	if (W == 0) {
		return 1;
	}
	if (DP[W][H] != 0) { 
		return DP[W][H]; 
	}
	DP[W][H] = DFS(W - 1, H + 1, DP) + DFS(W, H - 1, DP);

	return DP[W][H];

}