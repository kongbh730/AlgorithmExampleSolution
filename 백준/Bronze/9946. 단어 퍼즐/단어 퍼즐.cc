#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool input_data(pair<string, string> &CASE) {
    string str1, str2;

    cin >> str1 >> str2;
    CASE = { str1, str2 };
    if (str1 == "END" && str2 == "END") {
        return false;
    }
    return true;
}

string find_answer(pair<string, string> &CASE) {
    string str1 = CASE.first, str2 = CASE.second;

    sort(str1.begin(), str1.end());
    sort(str2.begin(), str2.end());

    if (str1 == str2) {
        return "same";
    }
    else {
        return "different";
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int i = 1;

    while (1) {
        pair<string, string> CASE;
        if (input_data(CASE)) {
            cout << "Case " << i << ": " << find_answer(CASE) << "\n";
        }
        else {
            break;
        }
        i++;
    }

    return 0;
}