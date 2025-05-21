#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    /*
    n = 1 -> 1
    n = 2 -> 2
    n = 3 -> 3
    n = 4 -> 5
    n = 5 ->
    n = 6 -> 
    */ 
    int i;
    vector<int> DP(60001, 0);
    
    DP[1] = 1;
    DP[2] = 2;
    for(i = 3; i <= n; i++){
        DP[i] = (DP[i-1] + DP[i-2]) % 1000000007;
        //cout <<  DP[i] << " ";
    }
    answer = DP[n];
    
    return answer;
}