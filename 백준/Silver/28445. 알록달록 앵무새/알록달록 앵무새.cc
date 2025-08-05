#include <iostream>
#include <vector>
#include <set>

using namespace std;

void input_data(vector<string>& colors) {
	int i;
	string color;

	for (i = 0; i < 4; i++) {
		cin >> color;
		colors.push_back(color);
	}

	return;
}

void find_answer(vector<string>& colors) {
	set<pair<string, string>> answer;
	int i, j;

	for (i = 0; i < colors.size(); i++) {
		for (j = 0; j < colors.size(); j++) {
			answer.insert({ colors[i], colors[j] });
		}
	}

	for (pair<string, string> temp : answer) {
		cout << temp.first << " " << temp.second << "\n";
	}

	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> colors;
	
	input_data(colors);
	find_answer(colors);

	return 0;
}