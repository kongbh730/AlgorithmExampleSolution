#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void input_data(vector<vector<char>>& room) {
	//cout << "input_data()\n";
	int i, j, N;

	cin >> N;
	room.resize(N, vector<char>(N));
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) {
			cin >> room[i][j];
		}
	}

	return;
}

void find_answer(vector<vector<char>>& room) {
	//cout << "find_answer()\n";
	int i, j, N = room.size(), col = 0, row = 0;
	bool lie;

	/*
	5
	.....
	.....
	XXXXX
	.....
	.....
	는 4, 10이 답임. X를 만나면 다시 탐색이 가능?
	*/

	//가로 누울 자리 찾기
	for (i = 0; i < N; i++) {
		lie = false;
		for (j = 1; j < N; j++) {
			if (!lie && room[i][j] == '.' && room[i][j - 1] == '.') {
				//최소 두 칸만 있으면 그 줄은 누울 수 있음
				col++;
				//cout << "가로 " << i << "줄 눕기 가능\n";
				lie = true;
			}
			if (room[i][j] == 'X') { // 중간에 짐을 만나면 다시 탐색?
				lie = false;
			}
		}
	}

	//세로 누울 자리 찾기
	for (i = 0; i < N; i++) {
		lie = false;
		for (j = 1; j < N; j++) {
			if (!lie && room[j][i] == '.' && room[j - 1][i] == '.') {
				//최소 두 칸만 있으면 그 줄은 누울 수 있음
				row++;
				//cout << "세로 " << i << "줄 눕기 가능\n";
				lie = true;
			}
			if (room[j][i] == 'X') {
				lie = false;
			}
		}
	}
	cout << col << " " << row << "\n";

	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<vector<char>> room;

	input_data(room);
	find_answer(room);

	return 0;
}