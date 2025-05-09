#include <iostream>
//#include <vector>
#include <set>

using namespace std;

void input_cards(int* n, int* m, /*vector<int>& cards*/ multiset<long long>& cards);
long long find_answer(int n, int m, /*vector<int>& cards*/ multiset<long long>& cards);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	//vector<int> cards;
	multiset<long long> cards;
	
	input_cards(&n, &m, cards);
	cout << find_answer(n, m, cards) << "\n";

	return 0;
}

void input_cards(int* n, int* m, /*vector<int>& cards*/ multiset<long long> &cards) {
	int i, a_i;

	cin >> *n >> *m;
	for (i = 0; i < *n; i++) {
		cin >> a_i;
		//cards.push_back(a_i);
		cards.insert(a_i);
	}

	return;
}

long long find_answer(int n, int m, /*vector<int>& cards*/ multiset<long long> &cards) {

	/*
	* 카드 합체가 최소가 되게 하려면?
	1, 2, 3, 4, 5 이고, m이 3인 경우
	1, 2를 더해서 3으로 만들고 3, 3, 3, 4, 5
	3, 3을 더해서 6으로 만들고 6, 6, 3, 4, 5 -> 3, 4, 5, 6, 6
	3, 4를 더해서 7으로 만들고 7, 7, 5, 6, 6 

	4, 2, 3, 1이고, m이 2인 경우
	3, 3, 3, 4
	3, 4, 6, 6

	매 순간 정렬을 하면? -> 시간이 오래 걸릴 거 같은데
	*/

	long long temp_sum, A, B;
	long long sum = 0;
	int i;

	for (i = 0; i < m; i++) {
		auto first = cards.begin();
		A = *first;
		cards.erase(first);

		auto second = cards.begin();
		B = *second;
		cards.erase(second);

		//cout << "A : " << A << " B : " << B << "\n";
		temp_sum = A + B;
		
		cards.insert(temp_sum);
		cards.insert(temp_sum);
	}

	for (long long card : cards) {
		sum += card;
	}

	return sum;
}