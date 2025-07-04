#include <iostream>
#include <algorithm>

using namespace std;

int input(int lower, int upper)
{
	//cout << "input()" << endl;
	int A;

	while (1)
	{
		cin >> A;
		if (A >= lower && A <= upper)
		{
			break;
		}
		else
		{
			;
		}
	}

	return A;
}

void input_arr(int* arr, int n)
{
	int i;

	for (i = 0; i < n; i++)
	{
		arr[i] = input(1, 1000);
	}

	return;
}

int find_result(int* A, int N)
{
	int i, j, result = 1;
	int* DP = new int[N];

	for (i = 0; i < N; i++)
	{
		DP[i] = 1;
	}
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < i; j++)
		{
			if (A[i] > A[j])
			{
				DP[i] = max(DP[i], DP[j] + 1);
				if (result < DP[i])
				{
					result = DP[i];
				}
				else
				{
					;
				}
			}
			else
			{
				;
			}
		}
	}
	delete[] DP;

	return result;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	int* A;

	N = input(1, 1000);
	A = new int[N];
	input_arr(A, N);
	cout << find_result(A, N) << "\n";

	delete[] A;

	return 0;
}