#include <iostream>

using namespace std;

int main(void) {
	int month, day;

	cin >> month >> day;
	if (month > 2) {
		cout << "After\n";
	}
	else if (month == 2) {
		if (day > 18) {
			cout << "After\n";
		}
		else if (day == 18) {
			cout << "Special\n";
		}
		else {//day < 18
			cout << "Before\n";
		}
	}
	else {//month < 2
		cout << "Before\n";
	}

	return 0;
}