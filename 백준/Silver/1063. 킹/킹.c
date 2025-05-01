#include <stdio.h>
#include <string.h>
#pragma warning(disable:4996)

void input_data(int* king_x, int* king_y, int* stone_x, int* stone_y, char move[][3], int *move_size);
void find_answer(int king_x, int king_y, int stone_x, int stone_y, char move[][3], int move_size);

int main(void) {
	int king_x, king_y, stone_x, stone_y, move_size;
	char move[51][3];

	input_data(&king_x, &king_y, &stone_x, &stone_y, move, &move_size);
	find_answer(king_x, king_y, stone_x, stone_y, move, move_size);

	return 0;
}

void input_data(int *king_x, int* king_y, int* stone_x, int* stone_y, char move[][3], int* move_size) {
	int N, i;
	char position[3];

	scanf("%s", position);
	*king_x = position[0] - 'A';
	*king_y = position[1] - '1';

	scanf("%s", position);
	*stone_x = position[0] - 'A';
	*stone_y = position[1] - '1';

	scanf("%d", move_size);
	for (i = 0; i < *move_size; i++) {
		scanf("%s", move[i]); 
	}

	return;
}

void find_answer(int king_x, int king_y, int stone_x, int stone_y, char move[][3], int move_size) {
	int i;
	int x_direction[8] = { 1, -1, 0,  0, 1, -1, 1, -1 };
	int y_direction[8] = { 0,  0, -1, 1, 1,  1, -1, -1 };
	int king_next_x, king_next_y, stone_next_x, stone_next_y;
	int dx = 0, dy = 0;

	//printf("king : %d %d / stone : %d %d\n", king_x, king_y, stone_x, stone_y);

	for (i = 0; i < move_size; i++) {
		if (strcmp(move[i], "R") == 0) {
			dx = x_direction[0];
			dy = y_direction[0];
		}
		else if (strcmp(move[i], "L") == 0) {
			dx = x_direction[1];
			dy = y_direction[1];
		}
		else if (strcmp(move[i], "B") == 0) {
			dx = x_direction[2];
			dy = y_direction[2];
		}
		else if (strcmp(move[i], "T") == 0) {
			dx = x_direction[3];
			dy = y_direction[3];
		}
		else if (strcmp(move[i], "RT") == 0) {
			dx = x_direction[4];
			dy = y_direction[4];
		}
		else if (strcmp(move[i], "LT") == 0) {
			dx = x_direction[5];
			dy = y_direction[5];
		}
		else if (strcmp(move[i], "RB") == 0) {
			dx = x_direction[6];
			dy = y_direction[6];
		}
		else if (strcmp(move[i], "LB") == 0) {
			dx = x_direction[7];
			dy = y_direction[7];
		}

		king_next_x = king_x + dx;
		king_next_y = king_y + dy;
		
		if (king_next_x >= 0 && king_next_x < 8 && king_next_y >= 0 && king_next_y < 8) {
			if (stone_x == king_next_x && stone_y == king_next_y) {
				stone_next_x = stone_x + dx;
				stone_next_y = stone_y + dy;
				if (stone_next_x >= 0 && stone_next_x < 8 && stone_next_y >= 0 && stone_next_y < 8) {
					stone_x = stone_next_x;
					stone_y = stone_next_y;
					king_x = king_next_x;
					king_y = king_next_y;
				}
			}
			else {
				king_x = king_next_x;
				king_y = king_next_y;
			}
		}

		//printf("king_next : %d %d / stone_next : %d %d\n", king_x, king_y, stone_x, stone_y);
		//printf("%c%c %c%c\n", king_x + 'A', king_y + '1', stone_x + 'A', stone_y + '1');
	}

	printf("%c%c\n", king_x + 'A', king_y + '1');
	printf("%c%c\n", stone_x + 'A', stone_y + '1');

	return;
}