#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string name;
	int i;
	vector<int> list;

	for (i = 0; i < 5; i++) {
		cin >> name;
		//cout << name.find("FBI") << "\n";
		if (name.find("FBI") >= 0 && name.find("FBI") < 5) {
			list.push_back(i + 1);
		}
	}
	if (list.size() > 0) {
		for (int num : list) {
			cout << num << "\n";
		}
	}
	else {
		cout << "HE GOT AWAY!\n";
	}

	return 0;
}