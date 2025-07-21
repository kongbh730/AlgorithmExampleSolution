#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M, N;

	while (1) {
		cin >> M >> N;
		if (M == 0 && N == 0) {
			break;
		}
		cout << M + N << "\n";
	}

	return 0;
}