#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void input_data(vector<pair<int, int>>& flavor) {
	int N, i, S, B;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> S >> B;
		flavor.push_back({ S, B });
	}

	return;
}

int find_answer(vector<pair<int, int>>& flavor) {
	int answer = 1000000000;
	int S_sum, B_sum, N = flavor.size(), i;

	for (int bit = 1; bit < (1 << N); ++bit) {
		S_sum = 1;
		B_sum = 0;

		for (i = 0; i < N; ++i) {
			if (bit & (1 << i)) {
				S_sum *= flavor[i].first;
				B_sum += flavor[i].second;
			}
		}
		answer = min(answer, abs(S_sum - B_sum));
	}

	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<pair<int, int>> flavor;

	input_data(flavor);
	cout << find_answer(flavor) << "\n";

	return 0;
}