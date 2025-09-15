#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string addBigInt(const string& a, const string& b) {
    string A = a, B = b;

    if (A.size() < B.size()) {
        swap(A, B);
    }
    B.insert(B.begin(), A.size() - B.size(), '0');

    string result = "";
    int carry = 0;

    for (int i = A.size() - 1; i >= 0; i--) {
        int sum = (A[i] - '0') + (B[i] - '0') + carry;
        carry = sum / 10;
        result.push_back((sum % 10) + '0');
    }
    if (carry) {
        result.push_back(carry + '0');
    }

    reverse(result.begin(), result.end());
    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string A, B;
    cin >> A >> B;

    cout << addBigInt(A, B) << "\n";

    return 0;
}
