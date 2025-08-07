#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_data(vector<string>& ingredients_A, vector<string>& ingredients_B) {
	int N, i;
	string name;

	cin >> N;
	for (i = 0; i < N; i++) {
		cin >> name;
		ingredients_A.push_back(name);
	}
	for (i = 0; i < N - 1; i++) {
		cin >> name;
		ingredients_B.push_back(name);
	}

	sort(ingredients_A.begin(), ingredients_A.end());
	sort(ingredients_B.begin(), ingredients_B.end());

	return;
}

string find_answer(vector<string>& ingredients_A, vector<string>& ingredients_B) {
	int i;
	
	for (i = 0; i < ingredients_A.size() - 1; i++) {
		if (ingredients_A[i] != ingredients_B[i]) {
			return ingredients_A[i];
		}
	}
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> ingredients_A;
	vector<string> ingredients_B;

	input_data(ingredients_A, ingredients_B);
	cout << find_answer(ingredients_A, ingredients_B) << "\n";

	return 0;
}