#include <iostream>
#include <vector>

using namespace std;

void input_data(int* N, int* M, int* J, vector<int>& apples);
int find_answer(int N, int M, int J, vector<int>& apples);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, J;
	vector<int> apples;

	input_data(&N, &M, &J, apples);
	cout << find_answer(N, M, J, apples);


	return 0;
}

void input_data(int* N, int* M, int* J, vector<int>& apples) {
	int i, apple;

	cin >> *N >> *M;
	cin >> *J;
	for (i = 0; i < *J; i++) {
		cin >> apple;
		apples.push_back(apple);
	}

	return;
}

int find_answer(int N, int M, int J, vector<int>& apples) {
	int answer = 0;
	int left, right, current, distance;
	int i, j;

	//N : 스크린 너비
	//M : 바구니 칸
	//J : 사과 개수

	left = 1;
	right = M;
	for (i = 0; i < J; i++) {
		current = apples[i];
		//cout << "original_location : " << left << "~" << right << "\n";

		if (current < left) {
			distance = left - current;
			
			left = left - distance;
			right = right - distance;
			answer = answer + distance;
		}
		else if (current >= left && current <= right) {
			;
		}
		else if (current > right) {
			distance = current - right;

			left = left + distance;
			right = right + distance;
			answer = answer + distance;
		}
		//cout << "answer : " << answer << "\n";
		//cout << "moved_location : " << left << "~" << right << "\n";
	}

	return answer;
}
