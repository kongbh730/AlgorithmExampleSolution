#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int i, T;
	string s;
	cout << fixed;
	cout.precision(2);

	cin >> T;
	cin.ignore();
	for (i = 0; i < T; i++) {
		float answer = 0;

		getline(cin, s);
		//cout << s << "\n";

		stringstream ss(s);
		string str;

		while (ss >> str) {
			if (str == "@") {//@
				answer *= 3;
			}
			else if (str == "%") {//%
				answer += 5;
			}
			else if (str == "#") {//#
				answer -= 7;
			}
			else {
				answer = stof(str);
			}
		}

		cout << answer << "\n";
	}


	return 0;
}