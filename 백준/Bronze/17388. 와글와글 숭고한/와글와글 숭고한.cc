#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int S, K, H;

	cin >> S >> K >> H;
	if (S + K + H >= 100) {
		cout << "OK\n";
	}
	else {
		int arr[3] = { S, K, H };
		sort(arr, arr + sizeof(arr) / sizeof(int));

		if (arr[0] == S) {
			cout << "Soongsil\n";
		}
		else if (arr[0] == K) {
			cout << "Korea\n";
		}
		else {
			cout << "Hanyang\n";
		}
	}

	return 0;
}