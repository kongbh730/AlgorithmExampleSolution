#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;
	int i;
	int S, Y, count = 0;
	vector<pair<int, int>> room(7, { 0, 0 });

	cin >> N >> K;
	for (i = 0; i < N; i++) {
		cin >> S >> Y;
		if (S == 1) {
			room[Y].second++;
		}
		else {
			room[Y].first++;
		}
	}

	/*for (auto temp : room) {
		cout << temp.first << " " << temp.second << "\n";
	}*/

	for (i = 1; i < room.size(); i++) {
		if (room[i].first == 0) {
			;
		}
		else if(room[i].first % K == 0){
			count += room[i].first / K;
		}
		else {
			count += ((room[i].first / K) + 1);
		}

		if (room[i].second == 0) {
			;
		}
		else if (room[i].second % K == 0) {
			count += room[i].second / K;
		}
		else {
			count += ((room[i].second / K) + 1);
		}
	}
	cout << count << "\n";

	return 0;
}