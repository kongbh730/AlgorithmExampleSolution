#include <iostream>
#include <sstream>

using namespace std;

int main(void) {
	int K, D, A;
	string str;
	char slash; 

	cin >> str;
	stringstream ss(str);
	ss >> K >> slash >> D >> slash >> A;
	if (K + A < D || D == 0) {
		cout << "hasu\n";
	}
	else {
		cout << "gosu\n";
	}

	return 0;
}