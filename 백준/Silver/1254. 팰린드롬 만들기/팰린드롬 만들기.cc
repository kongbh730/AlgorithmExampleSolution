#include <iostream>

using namespace std;

int find_answer(string S);
bool find_pelindrome(string temp_str);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;

	cin >> S;
	cout << find_answer(S) << "\n";

	return 0;
}

int find_answer(string S) {
	int answer = S.size() * 2 - 1;
	int i;

	for (i = 0; i < S.size(); i++) {
		string temp_str = S.substr(i, S.size() - i);
		if (find_pelindrome(temp_str)) {
			answer = S.size() + i;
			break;
		}
	}

	return answer;
}

bool find_pelindrome(string temp_str) {
	//cout << temp_str << "\n";

	int cnt = temp_str.size() / 2;
	for (int i = 0; i < cnt; i++) {
		if (temp_str[i] != temp_str[temp_str.size() - 1 - i]) {
			return false;
		}
	}

	return true;
}
