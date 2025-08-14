#include <iostream>
#include <algorithm> // reverse
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string bi, octo;
    cin >> bi;
    int i, j, sum, power;

    for (i = bi.length() - 1; i >= 0; i -= 3) {
        sum = 0;
        power = 1;

        for (j = i; j >= i - 2 && j >= 0; j--) {
            if (bi[j] == '1') {
                sum += power;
            }
            power *= 2;
        }
        octo += (char)(sum + '0'); 
    }

    reverse(octo.begin(), octo.end());
    cout << octo << "\n";

    return 0;
}
