#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>
#include <algorithm>

using namespace std;

bool compare(vector<int> A, vector<int> B){
    return A.size() < B.size();
}

vector<int> solution(string s) {
    vector<int> answer;
    vector<vector<int>> parsing_tuple;
    int i, j;
    string num = "";
    
    for(i = 0; i < s.length(); i++){
        if(isdigit(s[i])) {
            vector <int> temp;
            while(1){
                if(isdigit(s[i])){
                    num += s[i];
                    i++;
                }
                else if(s[i] == ','){
                    temp.push_back(stoi(num));
                    num = "";
                    i++;
                }
                else if(s[i] == '}'){
                    temp.push_back(stoi(num));
                    num = "";
                    break;
                }
            }
            parsing_tuple.push_back(temp);
        }
    }
    
    // cout << "파싱 결과\n";
    // for(i = 0; i < parsing_tuple.size(); i++){
    //     for(j = 0; j < parsing_tuple[i].size(); j++){
    //         cout << parsing_tuple[i][j] << " ";
    //     }
    //     cout << "\n";
    // }
    
    sort(parsing_tuple.begin(), parsing_tuple.end(), compare);
    
    // cout << "정렬 결과\n";
    // for(i = 0; i < parsing_tuple.size(); i++){
    //     for(j = 0; j < parsing_tuple[i].size(); j++){
    //         cout << parsing_tuple[i][j] << " ";
    //     }
    //     cout << "\n";
    // }
    
    int current;
    for(i = 0; i < parsing_tuple.size(); i++){
        for(j = 0; j < parsing_tuple[i].size(); j++){
            current = parsing_tuple[i][j];
            if(find(answer.begin(), answer.end(), current) == answer.end()){//존재 안함
                answer.push_back(current);
            }
        }
    }
    
    return answer;
}