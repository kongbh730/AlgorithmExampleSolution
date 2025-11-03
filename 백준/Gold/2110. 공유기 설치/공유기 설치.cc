#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_data(int* N, int* C, vector<int>& x) {
	int i, xi;

	cin >> *N >> *C;
	for (i = 0; i < *N; i++) {
		cin >> xi;
		x.push_back(xi);
	}

	return;
}

bool canInstall(const vector<int>& x, int N, int C, int d) {
    int count = 1;
    int last = x[0];
    int i;

    for (i = 1; i < N; i++) {
        if (x[i] - last >= d) {
            count++;
            last = x[i];

            if (count >= C) {
                return true;
            }
        }
    }
    return false;
}

int find_answer(int N, int C, vector<int>& x) {
    sort(x.begin(), x.end());

    int left = 1, right = x.back() - x.front(), mid;
    int answer = 0;

    while (left <= right) {
        mid = left + (right - left) / 2;
        if (canInstall(x, N, C, mid)) {
            answer = mid;      
            left = mid + 1;
        }
        else {
            right = mid - 1;   
        }
    }
    return answer;
}

int main(void) {
	int N, C;
	vector <int> x;

	input_data(&N, &C, x);
	cout << find_answer(N, C, x) << "\n";

	return 0;
}