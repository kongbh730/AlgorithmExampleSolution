#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_city(vector<int>& city) {
	int n, i, v;

	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> v;
		city.push_back(v);
	}

	return;
}

int find_answer(vector<int>& city) {
	int answer = 0, i;

	sort(city.begin(), city.end());
	for (i = 0; i < city.size() - 1; i++) {
		answer += city[i];
	}

	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> city;

	input_city(city);
	cout << find_answer(city) << "\n";

	return 0;
}