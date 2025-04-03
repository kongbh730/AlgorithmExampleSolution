#include <iostream>
#include <map>

using namespace std;

void input_data(map<char, int>& player);
void find_answer(map<char, int>& player);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	map<char, int> player;

	input_data(player);
	find_answer(player);

	return 0;
}

void input_data(map<char, int>& player) {
	int i, N;
	string name;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> name;
		player[name[0]]++;
	}

	//for (auto temp : player) {
	//	cout << temp.first << " " << temp.second << "\n";
	//}

	return;
}

void find_answer(map<char, int>& player) {
	bool give_up = true;

	for (auto temp : player) {
		if (temp.second >= 5) {
			give_up = false;
			cout << temp.first;
		}
	}
	if (give_up) {
		cout << "PREDAJA";
	}
	cout << "\n";
	return;
}