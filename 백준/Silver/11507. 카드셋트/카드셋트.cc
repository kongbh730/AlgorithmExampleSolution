#include <iostream>
#include <set>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;
	set<string> cards;
	int i;
	int cards_num[4] = { 13,13,13,13 };

	cin >> S;
	for (i = 0; i < S.length(); i += 3) {
		cards.insert(S.substr(i, 3));
		if (S[i] == 'P') {
			cards_num[0]--;
		}
		else if (S[i] == 'K') {
			cards_num[1]--;
		}
		else if (S[i] == 'H') {
			cards_num[2]--;
		}
		else if (S[i] == 'T') {
			cards_num[3]--;
		}
	}
	//cout << "cards.size() : " << cards.size() << "\n";

	if (cards.size() * 3 == S.length()) {
		for (int temp : cards_num) {
			cout << temp << " ";
		}
	}
	else {
		cout << "GRESKA";
	}
	cout << "\n";

	return 0;
}