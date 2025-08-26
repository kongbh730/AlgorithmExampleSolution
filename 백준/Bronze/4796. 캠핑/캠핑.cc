#include <iostream>

using namespace std;

int find_answer(int L, int P, int V) {
	int answer = 0;

	//연속하는 P일 중, L일 동안만 사용 가능, V일짜리 휴가 시작
	//5, 8, 20 -> 14
	//연속하는 P8일 중 L5일 동안만 이용 가능, V20일짜리 휴가 시작
	//V20 / P8 = 2, 2 * L5 = 10
	//20 % 8 = 4, 10 + 4 = 14

	//연속하는 8일 중 5일 동안만 이용 가능, 17일짜리 휴가 시작
	//17 / 8 = 2, 2 * 5 = 10
	//17 % 8 = 1, 10 + 1 = 11

	int div, mod;

	div = V / P;
	mod = V % P;

	answer = div * L + (mod <= L ? mod : L);

	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int L, P, V, i = 1;

	while (1) {
		cin >> L >> P >> V;
		if (L == 0 && P == 0 && V == 0) {
			break;
		}
		cout << "Case " << i << ": " << find_answer(L, P, V) << "\n";
		i++;
	}

	return 0;
}