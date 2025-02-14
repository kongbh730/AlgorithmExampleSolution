#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_and_findAnswer() {
	int M, i, j, num;
	vector<bool> S(21, false);
	string state;

	cin >> M;
	for (i = 0; i < M; i++) {
		cin >> state;
		if (state == "add") {
			cin >> num;
			if (S[num] == false) {
				S[num] = true;
			}
		}
		else if (state == "remove") {
			cin >> num;
			if (S[num] == true) {
				S[num] = false;
			}
		}
		else if (state == "check") {
			cin >> num;
			if (S[num]) {
				cout << "1\n";
			}
			else {
				cout << "0\n";
			}
		}
		else if (state == "toggle") {
			cin >> num;
			S[num] = !S[num];
		}
		else if (state == "all") {
			for (j = 1; j <= 20; j++) {
				S[j] = true;
				//cout << S[j];
			}
			//cout << "\n";
		}
		else if (state == "empty") {
			for (j = 1; j <= 20; j++) {
				S[j] = false;
				//cout << S[j];
			}
			//cout << "\n";
		}
	}

	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	input_and_findAnswer();

	return 0;
}