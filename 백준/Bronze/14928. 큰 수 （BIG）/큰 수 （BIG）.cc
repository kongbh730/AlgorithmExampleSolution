#include <iostream>
#include <string>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s;
	long long mod = 20000303;
	long long N = 0;

	cin >> s;
	for (char ch : s) {
		int num = ch - '0';
		N = (N * 10 + num) % mod;
	}

	cout << N << "\n";

	return 0;
}