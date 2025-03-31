#include <iostream>
#include <vector>

using namespace std;

void input_data(int* A, int* B, vector<int>& numbers);
void find_answer(int A, int B, vector<int>& numbers);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A, B;
	vector<int> numbers;

	input_data(&A, &B, numbers);
	find_answer(A, B, numbers);

	return 0;
}

void input_data(int* A, int* B, vector<int>& numbers) {
	int m, i, num;

	cin >> *A >> *B;
	cin >> m;
	for (i = 0; i < m; i++) {
		cin >> num;
		numbers.push_back(num);
	}

	return;
}

void find_answer(int A, int B, vector<int>& numbers) {
	//A진법을 B진법으로 바꿈
	//numbers에 들어있는 숫자들은 A진법의 숫자의 자리수의 개수
	//A진법으로 나타낸 수를 B진법으로 변환

	/*
	17진법 2 16을 8진법 으로 바꾸면 6 2
	17진법을 10진법으로 바꾸고, 8진법으로?
	*/

	int decimal = 0;
	int i;
	int div = 1;
	vector<int> answer;
	
	for (i = numbers.size() - 1; i >= 0; i--) {
		decimal += (numbers[i] * div);
		div *= A;
		//cout << "decimal : " << decimal << " / div : " << div << "\n";
	}

	while (decimal > 0) {
		answer.push_back(decimal % B);
		decimal /= B;
	}
	for (i = answer.size() - 1; i >= 0; i--) {
		cout << answer[i] << " ";
	}
	cout << "\n";

	return;
}