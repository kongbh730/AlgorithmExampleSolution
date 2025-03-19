#include <iostream>
#include <vector>

using namespace std;

int find_answer(int T);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int D;
	
	cin >> D;
	cout << find_answer(D) << "\n";

	return 0;
}

int find_answer(int D) {
	int i, j, answer = 0;
	//vector<vector<int>> map{
	//	{1, 2},// 정보과학관0과 연결
	//	{0, 2, 3},// 전산관1과 연결
	//	{0, 1, 3, 4},// 미래관2과 연결
	//	{1, 2, 4, 5},// 신양관3과 연결
	//	{2, 3, 5, 7},// 한경직기념관4과 연결
	//	{3, 4, 6},// 진리관5과 연결
	//	{5, 7},// 학생회관6과 연결
	//	{4, 6} // 형남공학관7과 연결
	//};
	//DFS? : 시간 너무 오래걸림...?
	//DP?

	vector<long long> DP(8, 0);
	vector<long long> next(8, 0);

	DP[0] = 1;
	for (i = 0; i < D; i++) {
		next[0] = DP[1] + DP[2];
		next[1] = DP[0] + DP[2] + DP[3];
		next[2] = DP[0] + DP[1] + DP[3] + DP[4];
		next[3] = DP[1] + DP[2] + DP[4] + DP[5];
		next[4] = DP[2] + DP[3] + DP[5] + DP[7];
		next[5] = DP[3] + DP[4] + DP[6];
		next[6] = DP[5] + DP[7];
		next[7] = DP[4] + DP[6];

		for (j = 0; j < 8; j++) {
			DP[j] = next[j] % 1000000007;
			//cout << DP[j] << " ";
		}
		//cout << "\n";
	}
	answer = DP[0];

	return answer;
}