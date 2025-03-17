#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    //DFS 알고리즘 사용
    stack<pair<int, int>> st;
    int current_sum = 0, next_sum = 0, current_degree = 0, i;
    
    st.push({current_sum, current_degree});
    while(!st.empty()){
        current_sum = st.top().first;
        current_degree = st.top().second;
        st.pop();
        
        for(i = 0; i <= 1; i++){
            if(i == 0){
                next_sum = current_sum + numbers[current_degree];
            }
            else{
                next_sum = current_sum - numbers[current_degree];
            }
            if(current_degree + 1 == numbers.size()){
                if(next_sum == target){
                    cout << "target 도착\n";
                    answer++;
                }
                else{
                    ;
                }
            }
            else{
                st.push({next_sum, current_degree + 1});
            }
        }
    }
    
    return answer;
}