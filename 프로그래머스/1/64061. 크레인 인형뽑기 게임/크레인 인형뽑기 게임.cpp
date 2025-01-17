#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    int i, j;
    stack <int> dolls;
    
    for(int move : moves){
        cout << "크레인 현재 위치 : " << move << "\n";
        for(i = 0; i < board[move - 1].size(); i++){
            cout << board[i][move - 1] << " ";
            if(board[i][move - 1] != 0){
                if(!dolls.empty() && dolls.top() == board[i][move - 1]){
                    cout << "pop()";
                    dolls.pop();
                    answer += 2;
                }
                else{
                    dolls.push(board[i][move - 1]);
                }
                board[i][move - 1] = 0;
                break;
            }
        }
        cout << "\n";
        
    }
    
    
    return answer;
}