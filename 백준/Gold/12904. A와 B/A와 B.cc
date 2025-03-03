#include <iostream>
#include <algorithm>

using namespace std;

//S에서 T가 아니라 T에서 S로 이동
int find_answer(string S, string T) {
    while (T.length() > S.length()) {
        if (T.back() == 'A') {//문자열 제일 뒤가 A라면?
            T.pop_back();  // A 제거
            //cout << "back A 제거\n";
        }
        else {//문자열 제일 뒤가 B라면?
            T.pop_back();  // B 제거
            reverse(T.begin(), T.end());  // 뒤집기
            //cout << "back B 제거 + reverse\n";
        }
        //cout << T << "\n";
    }
    
    if (S == T) {
        return 1;
    }
    else {
        return 0;
    }
}

int main(void) {
	string S, T;

	cin >> S >> T;
	cout << find_answer(S, T) << "\n";

	return 0;
}