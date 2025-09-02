#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> strs;
	string s;
	int N, i;

	cin >> N;
	cin.ignore();
	for (i = 0; i < N; i++) {
		getline(cin, s);
		strs.push_back(s);
	}

	for (i = 0; i < N; i++) {
		strs[i][0] = toupper(strs[i][0]);
		cout << strs[i] << "\n";
	}

	return 0;
}