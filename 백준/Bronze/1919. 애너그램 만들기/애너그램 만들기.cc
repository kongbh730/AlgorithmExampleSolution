#include <iostream>
#include <vector>

using namespace std;

int find_answer(string str1, string str2);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string str1, str2;

	cin >> str1 >> str2;
	cout << find_answer(str1, str2) << "\n";

	return 0;
}

int find_answer(string str1, string str2) {
	int answer = 0;
	vector<int> alphabet1(30, 0);
	vector<int>	alphabet2(30, 0);
	int i;

	for (i = 0; i < str1.size(); i++) {
		alphabet1[str1[i] - 'a']++;
	}
	for (i = 0; i < str2.size(); i++) {
		alphabet2[str2[i] - 'a']++;
	}

	for (i = 0; i < alphabet1.size(); i++) {
		if (alphabet1[i] == alphabet2[i]) {
			continue;
		}
		else {
			answer += min(abs(alphabet1[i] - alphabet2[i]), abs(alphabet2[i] - alphabet1[i]));
		}
	}

	return answer;
}