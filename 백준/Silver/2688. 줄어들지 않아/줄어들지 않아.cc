#include <iostream>
#include <vector>

using namespace std;

long long find_answer(int n, vector<vector<long long>> &dp) {
	//n자리 수 문자열 중 오른쪽 수가 왼쪽 수보다 큰 수 개수 구하기
	long long answer = 0;
	int i;

	for (i = 0; i <= 9; i++) {
		answer += dp[n][i];
		//cout << answer << " ";
	}
	//cout << "\n";

	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, n, i, j, k;
	vector<vector<long long>> dp(65, vector<long long>(10, 0));

	for (i = 0; i <= 9; i++) {
		dp[1][i] = 1;
	}

	for (i = 2; i <= 64; i++) {
		for (j = 0; j <= 9; j++){
			for (k = j; k <= 9; k++){
				dp[i][j] += dp[i - 1][k];
			}
		}
	}
	
	cin >> T;
	while (T--) {
		cin >> n;
		cout << find_answer(n, dp) << "\n";
	}

	return 0;
}