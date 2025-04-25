#include <stdio.h>
#include <string.h>
#pragma warning(disable:4996)

struct Member {
	char name[12];
	int age;
	int weight;
};

int main(void) {
	struct Member member[100];
	int age, weight, i = 0, len;
	char name[12];

	while (1) {
		scanf("%s %d %d", name, &age, &weight);

		if (strcmp(name, "#") == 0 && age == 0 && weight == 0) {
			break;
		}

		strcpy(member[i].name, name);
		member[i].age = age;
		member[i].weight = weight;
		i++;
	}
	len = i;

	for (i = 0; i < len; i++) {
		if (member[i].age > 17 || member[i].weight >= 80) {
			printf("%s Senior\n", member[i].name);
		}
		else {
			printf("%s Junior\n", member[i].name);
		}
	}

	return 0;
}