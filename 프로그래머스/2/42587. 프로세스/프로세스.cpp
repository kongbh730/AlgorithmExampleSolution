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
            cout << q.front().first << "의 우선순위 : " << pq.top()<< "\n";
            answer++;
            break;
        }
        else if(q.front().second == pq.top()){
            cout << "큐 제거 : " << q.front().first << "의 우선순위 : " << pq.top()<< "\n";
            pq.pop();
            q.pop();
            answer++;
        }
        else{
            cout << "현재 pq의 우선순위 : " << pq.top() << "\n";
            cout << "큐 뒤에 추가 : " << q.front().first << "의 우선순위 : " << q.front().second << "\n";
            q.push(q.front());
            q.pop();
        }
    }
    
    return answer;
}