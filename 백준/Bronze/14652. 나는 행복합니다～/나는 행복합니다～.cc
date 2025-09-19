#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, K, x, y;

	cin >> N >> M >> K;
	y = K / M;
	x = K % M;

	cout << y << " " << x << "\n";
	
	return 0;
}