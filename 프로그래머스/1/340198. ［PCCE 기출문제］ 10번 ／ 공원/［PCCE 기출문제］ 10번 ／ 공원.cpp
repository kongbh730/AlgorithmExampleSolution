#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> mats, vector<vector<string>> park) {
    int answer = -1;
    int i, j;
    vector<vector<int>> DP(park.size(), vector<int>(park[0].size(), 0));
    int max_count = 0;

    //mats : 지민이가 가진 돗자리 종류
    for(i = 0; i < park.size(); i++){
        for(j = 0; j < park[i].size(); j++){
            if(park[i][j] == "-1"){
                if(i == 0 || j == 0){
                    DP[i][j] = 1;
                }
                else{
                    DP[i][j] = min({DP[i - 1][j], DP[i][j - 1], DP[i - 1][j - 1]}) + 1;
                }
                max_count = max(max_count, DP[i][j]);
            }
        }
    }
    
    for(i = 0; i < DP.size(); i++){
        for(j = 0; j < DP[i].size(); j++){
            cout << DP[i][j] << " ";
        }
        cout << "\n";
    }
    
    sort(mats.begin(), mats.end(), greater<>());
    for(i = 0; i < mats.size(); i++){
        if(mats[i] <= max_count){
            answer = mats[i];
            break;
        }
    }
    
    return answer;
}