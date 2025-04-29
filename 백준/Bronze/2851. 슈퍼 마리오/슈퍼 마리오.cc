#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int i, score, answer, current;
	vector<int> mushroom(10, 0);
	
	cin >> mushroom[0];
	for (i = 1; i < 10; i++) {
		cin >> score;
		mushroom[i] = mushroom[i - 1] + score;
	}

	answer = mushroom[0];
	for (i = 1; i < 10; i++) {
		current = mushroom[i];

		if (abs(100 - current) < abs(100 - answer)) {
			answer = current;
		}
		else if (abs(100 - current) == abs(100 - answer) && current > answer) {
			answer = current;
		}
		//cout << answer << "\n";
	}

	cout << answer << "\n";

	return 0;
}