#include <iostream>
#include <vector>

using namespace std;

void input_data(vector<vector<int>>& cards);
int find_answer(vector<vector<int>>& cards);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<vector<int>> cards;

	input_data(cards);
	cout << find_answer(cards) << "\n";

	return 0;
}

void input_data(vector<vector<int>>& cards) {
	int N, i, j;

	cin >> N;
	cards.resize(N, vector<int>(5, 0));
	for (i = 0; i < cards.size(); i++) {
		for (j = 0; j < cards[i].size(); j++) {
			cin >> cards[i][j];
		}
	}

	return;
}

int find_answer(vector<vector<int>>& cards) {
	int i, N = cards.size(), j, k, l;
	int max_index = 0, current_max = 0, max_value, temp_value;

	for (i = 0; i < N; i++) {
		max_value = 0;

		for (j = 0; j < cards[i].size() - 2; j++) {
			for (k = j + 1; k < cards[i].size() - 1; k++) {
				for (l = k + 1; l < cards[i].size(); l++) {
					temp_value = cards[i][j] + cards[i][k] + cards[i][l];

					if ((temp_value % 10) >= max_value) {
						max_value = (temp_value % 10);
						//cout << "max_value : " << max_value << "\n";
					}
				}
			}
		}
		if (max_value >= current_max) {
			current_max = max_value;
			max_index = i + 1;
			//cout << "max_index : " << max_index << "\n";
		}
	}

	return max_index;
}