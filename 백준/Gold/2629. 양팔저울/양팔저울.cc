#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int weight_N, bead_N;
int weight[31];
bool dp[31][15001];

void input_weight() {
	int i;

	cin >> weight_N;
	for (i = 0; i < weight_N; i++) {
		cin >> weight[i];
	}
}

void DFS(int A, int B)
{
	if (A > weight_N || dp[A][B])
	{
		return;
	}

	dp[A][B] = true;

	DFS(A + 1, B);
	DFS(A + 1, abs(B - weight[A]));
	DFS(A + 1, B + weight[A]);
}

void find_answer() {
	int i, bead;
	
	cin >> bead_N;
	for (i = 0; i < bead_N; i++)
	{
		cin >> bead;
		if (bead > 15000)
		{
			cout << "N ";
		}
		else if (dp[weight_N][bead])
		{
			cout << "Y ";
		}
		else
		{
			cout << "N ";
		}
	}
	
	return;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	input_weight();
	DFS(0, 0);
	find_answer();

	return 0;
}