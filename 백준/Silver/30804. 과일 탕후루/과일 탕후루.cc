#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

void input_data(int* N, vector<int>& S) {
    int i, Si;

    cin >> * N;
    for (i = 0; i < *N; i++) {
        cin >> Si;
        S.push_back(Si);
    }

    return;
}

int find_answer(int N, vector<int>& S) {
    int answer = 0;
    int left = 0, right, count = 0;
    unordered_map<int, int> cnt;  

    for (right = 0; right < N; right++) {
        if (cnt[S[right]]++ == 0) {
            count++;
        }
        while (count > 2) {
            if (--cnt[S[left]] == 0) count--;
            left++;
        }
        answer = max(answer, right - left + 1);
    }

    return answer;
}

int main(void) {
    int N;
    vector<int> S;

    input_data(&N, S);
    cout << find_answer(N, S) << "\n";

    return 0;
}