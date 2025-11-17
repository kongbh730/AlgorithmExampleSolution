#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, i, j;
	string str;
	vector<vector<char>> bread;

	cin >> N >> M;
	for (i = 0; i < N; i++) {
		vector<char> temp;
		cin >> str;
		for (j = 0; j < M; j++) {
			temp.push_back(str[j]);
		}
		bread.push_back(temp);
	}

	for (i = 0; i < bread.size(); i++) {
		for (j = bread[i].size() - 1; j >= 0; j--) {
			cout << bread[i][j];
		}
		cout << "\n";
	}

	return 0;
}