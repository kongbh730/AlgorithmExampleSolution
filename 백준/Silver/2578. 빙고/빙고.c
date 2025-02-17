#include <stdio.h>
#include <stdbool.h>

#pragma warning (disable:4996);

void input_data(int bingo[26][2], int speaking_bingo[5][5]) {
	int i, j, num;

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			scanf("%d", &num);
			bingo[num][0] = i;
			bingo[num][1] = j;
		}
	}

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			scanf("%d", &speaking_bingo[i][j]);
		}
	}

	return;
}

int check_bingo(bool check[5][5]) {
    int i, j;
    int bingo_count = 0;

    // 가로 줄 빙고
    for (i = 0; i < 5; i++) {
        bool row_bingo = true;
        for (j = 0; j < 5; j++) {
            if (!check[i][j]) {
                row_bingo = false;
                break;
            }
        }
        if (row_bingo) { 
            bingo_count++; 
        }
    }

    // 세로 줄 빙고
    for (j = 0; j < 5; j++) {
        bool col_bingo = true;
        for (i = 0; i < 5; i++) {
            if (!check[i][j]) {
                col_bingo = false;
                break;
            }
        }
        if (col_bingo) { 
            bingo_count++; 
        }
    }

    // 왼위 -> 오른아래 대각선
    bool diag1_bingo = true;
    for (i = 0; i < 5; i++) {
        if (!check[i][i]) {
            diag1_bingo = false;
            break;
        }
    }
    if (diag1_bingo) {
        bingo_count++;
    }

    // 오른위 -> 왼아래 대각선
    bool diag2_bingo = true;
    for (i = 0; i < 5; i++) {
        if (!check[i][4 - i]) {
            diag2_bingo = false;
            break;
        }
    }
    if (diag2_bingo) { 
        bingo_count++; 
    }

    return bingo_count;
}

int count_bingo(int bingo[26][2], int speaking_bingo[5][5]) {
	int count = 0;
	bool check[5][5] = { false };
	int i, j, current, x, y;

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			current = speaking_bingo[i][j];
			count++;

			x = bingo[current][1];
			y = bingo[current][0];
			check[y][x] = true;

			if (check_bingo(check) >= 3)
			{
				return count;
			}
		}
	}

	return count;
}

int main(void) {
	//int bingo[5][5] = { 0 };
	//int my_bingo[5][5] = { 0 };
	
	//1 2 3 4 5 -> 빙고 번호
	//0 1 2 3 4 -> x좌표
	//0 1 2 3 4 -> y좌표

	int bingo[26][2];//[i][j][1] : x좌표, [i][j][0] : y좌표
	int speaking_bingo[5][5]; //사회자가 말하는 빙고

	input_data(bingo, speaking_bingo);
	printf("%d\n", count_bingo(bingo, speaking_bingo));

	return 0;
}