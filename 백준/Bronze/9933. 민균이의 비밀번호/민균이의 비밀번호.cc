#include <iostream>
#include <vector>

using namespace std;

void input_data(vector<string> &word);
void find_answer(vector<string>& word);
bool compare(string& current_str, string& compare_str);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> word;

	input_data(word);
	find_answer(word);

	return 0;
}

void input_data(vector<string>& word) {
	int i, N;
	string str;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> str;
		word.push_back(str);
	}

	return;
}

void find_answer(vector<string>& word) {
	int answer = 0;
	int i, j;
	string current_str, compare_str;

	for (i = 0; i < word.size(); i++) {
		current_str = word[i];
		for (j = 0; j < word.size(); j++) {
			compare_str = word[j];
			
			if (current_str.size() == compare_str.size() && 
				compare(current_str, compare_str)) {
				cout << current_str.size() << " " << current_str[(current_str.size() - 1) / 2] << "\n";
				return;
			}
		}
	}

	return;
}

bool compare(string &current_str, string &compare_str) {
	int i;

	for (i = 0; i < current_str.size(); i++) {
		if (current_str[i] != compare_str[current_str.size() - i - 1]) {
			return false;
		}
	}

	return true;
}