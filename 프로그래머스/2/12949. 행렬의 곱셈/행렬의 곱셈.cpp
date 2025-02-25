#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    int i, j, k, res;
    
    for(i = 0; i < arr1.size(); i++){
        vector<int> temp;
        for(j = 0; j < arr2[0].size(); j++){
            res = 0;
            for(k = 0; k < arr1[i].size(); k++){
                res += (arr1[i][k] * arr2[k][j]);
            }
            temp.push_back(res);
        }
        
        cout << "[";
        for(int num : temp){
            cout << num << ", ";
        }
        cout << "]";
        
        answer.push_back(temp);
    }
    
    return answer;
}