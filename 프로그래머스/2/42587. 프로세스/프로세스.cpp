#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue <pair<int, int>> q;
    int i;
    
    for(i = 0; i < priorities.size(); i++){
        pq.push(priorities[i]);
        q.push({i, priorities[i]});
    }
    
    while(!q.empty()){
        if(q.front().second == pq.top() && q.front().first == location){//찾고나 하는 인덱스를 찾은 경우
            answer++;
            break;
        }
        else if(q.front().second == pq.top()){
            pq.pop();
            q.pop();
            answer++;
            cout << "큐 제거\n";
        }
        else{
            q.push(q.front());
            q.pop();
            cout << "큐 뒤에 추가\n";
        }
    }
    
    return answer;
}