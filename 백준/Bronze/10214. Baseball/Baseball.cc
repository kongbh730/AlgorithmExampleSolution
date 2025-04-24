#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, i, j, Y, K;

	cin >> T;
	for (i = 0; i < T; i++) {
		int korea = 0, yonsei = 0;

		for (j = 0; j < 9; j++) {
			cin >> Y >> K;
			yonsei += Y;
			korea += K;
		}

		if (yonsei > korea) {
			cout << "Yonsei\n";
		}
		else if (yonsei < korea) {
			cout << "Korea\n";
		}
		else {
			cout << "Draw\n";
		}
	}

	return 0;
}