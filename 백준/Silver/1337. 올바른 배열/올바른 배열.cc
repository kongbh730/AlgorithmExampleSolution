#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_data(vector<int>& v, int* N) {
	int i, num;

	cin >> *N;
	for (i = 0; i < *N; i++) {
		cin >> num;
		v.push_back(num);
	}

	return;
}

int find_answer(vector<int>& v, int N) {
	int answer = 5, count;
	int left = 0, right;
	sort(v.begin(), v.end());
	
	for (right = 0; right < N; right++) {
		while (v[right] - v[left] > 4) left++;
		count = right - left + 1;
		answer = min(answer, 5 - count);
	}

	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> v;
	int N;

	input_data(v, &N);
	cout << find_answer(v, N);

	return 0;
}