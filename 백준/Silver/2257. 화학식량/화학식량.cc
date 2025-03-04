#include <iostream>
#include <stack>
#include <map>

using namespace std;

int find_answer(string chemical) {
    stack<int> st;
	int i, j;
	int sum = 0;
    char current;

	map <char, int> atom = { {'C', 12},{'H', 1},{'O', 16}};

    for (int i = 0; i < chemical.size(); i++) {
        // 1. ')'를 만나면 처음 만나는 '('까지의 화학식 분석
        // 1-2. 알파벳의 경우 temp_sum에 더하기
        // 1-3. 숫자의 경우 앞의 문자에 곱하기
        // 2. ')'이후 숫자를 만나면 ()안의 화학식에 곱하기
        current = chemical[i];

        if (atom.count(current)) {  // H, C, O와 같은 원소
            st.push(atom[current]);
        }
        else if (current == '(') {  // 여는 괄호
            st.push(-1);  // 괄호의 시작을 -1로 표시
        }
        else if (current == ')') {  // 닫는 괄호
            int temp_sum = 0;
            while (!st.empty() && st.top() != -1) {
                temp_sum += st.top();
                st.pop();
            }
            st.pop();  // '(' 제거
            st.push(temp_sum);
        }
        else if (isdigit(current)) {  // 숫자인 경우
            int num = current - '0';
            int temp = st.top();
            st.pop();
            st.push(temp * num);
        }
    }

    // 최종 스택에 남아있는 값들을 더하기
    while (!st.empty()) {
        sum += st.top();
        st.pop();
    }

    return sum;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string chemical;

	cin >> chemical;
	cout << find_answer(chemical) << "\n";

	return 0;
}