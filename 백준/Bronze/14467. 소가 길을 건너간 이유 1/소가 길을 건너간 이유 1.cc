#include <iostream>
#include <vector>

using namespace std;

int input_cows_and_find_answer(vector<int>& cows);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> cows(11, -1);

	cout << input_cows_and_find_answer(cows);

	return 0;
}

int input_cows_and_find_answer(vector<int>& cows) {
	int i, N, cow_num, location, count = 0;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> cow_num >> location;
		if (cows[cow_num] == -1) {
			cows[cow_num] = location;
		}
		else {
			if (cows[cow_num] == location) {
				;
			}
			else {//cows[cow_num] != location
				cows[cow_num] = location;
				count++;
			}
		}
	}

	return count;
}