#include <iostream>
#include <vector>

using namespace std;

void input_data(int* n, vector<int>& node) {
	int i, parent;

	cin >> *n;
	node.resize(*n + 1);
	for (i = 1; i <= *n; i++) {
		cin >> parent;
		node[i] = parent;
	}

	return;
}

int dfs(vector<int>& node, int current, int layer) {
	if (node[current] == -1) {
		return layer;
	}
	else {
		return dfs(node, node[current], layer + 1);
	}
}

void find_answer(int n, vector<int>& node) {
	int i;

	for (i = 1; i <= n; i++) {
		int layer = 0;

		cout << dfs(node, i, layer) << "\n";
	}

	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	vector<int> node;

	input_data(&n, node);
	find_answer(n, node);

	return 0;
}