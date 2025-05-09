#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    int max_sum;
    int n = land.size(), m = land[0].size();
    int i, j, k;

    vector<vector<int>> DP(n + 1, vector<int> (m, 0));
    for(i = 0; i < m; i++){
        DP[0][i] = 0;
    }
    
    for(i = 1; i <= n; i++){
        for(j = 0; j < m; j++){
            for(k = 0; k < m; k++){
                if(j == k){
                    continue;
                }
                DP[i][j] = max(DP[i][j], DP[i-1][k] + land[i-1][j]);
            }
        }
        
        // for(int num : DP[i]){
        //     cout << num << " ";
        // }
        // cout << "\n";
    }
    
    max_sum = 0;
    for(int num : DP[n]){
        max_sum = max(max_sum, num);
    }
    answer = max_sum;
    
    return answer;
}