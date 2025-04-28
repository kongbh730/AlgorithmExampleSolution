#include <iostream>
#include <vector>
#include <stack>
#include <map>
#include <algorithm>

using namespace std;

bool find_answer(string S, string T);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S, T;
	
	cin >> S >> T;
	cout << find_answer(S, T) << "\n";

	return 0;
}

bool find_answer(string S, string T) {
	//뒤에 A 추가 -> 뒤에 A 없애기
	//뒤에 B 추가하고 문자열 뒤집기 -> 문자열 뒤집고 B 없애기
	//스택을 사용한 DFS로 구현?

	stack<string> st;
	map<string, bool> visited;
	int i;
	string current, next;

	st.push(T);
	visited[T] = true;
	while (!st.empty()) {
		current = st.top();
		st.pop();

		if (visited[S]) {
			return true;
		}
		if (current.length() <= S.length()) {
			continue;
		}

		//뒤에 A 없애기
		if (current.back() == 'A') {
			next = current.substr(0, current.size() - 1);
			if (visited[next] == NULL) {
				//cout << "뒤에 A 제거 : " << next << "\n";
				visited[next] = true;
				st.push(next);
			}
		}

		//문자열 뒤집고 B 없애기
		next.resize(current.size() - 1);
		if (current.front() == 'B') {
			reverse_copy(current.begin() + 1, current.end(), next.begin());
			if (visited[next] == NULL) {
				//cout << "뒤집고 뒤에 B 제거 : " << next << "\n";
				visited[next] = true;
				st.push(next);
			}
		}
	}

	return false;
}