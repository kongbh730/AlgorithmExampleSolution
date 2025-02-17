#include <string>
#include <vector>

#include <iostream>
#include <stack>

using namespace std;

int solution(int n, int w, int num) {
    int answer = 0;
    int i, j, line, box_line;
    bool direction = true;
    //n은 박스 개수
    //w는 너비
    //num은 꺼내야 하는 박스 번호
    vector<stack<int>> box_stack(w, stack<int>());
    
    //상자 쌓기
    for(i = 1; i <= n; i++){
        if(direction){//오른쪽으로 쌓기
            line = (i - 1) % w;
            box_stack[line].push(i);
        }
        else{//왼쪽으로 쌓기
            line = (w - 1) - ((i - 1) % w);
            box_stack[line].push(i);
        }
        
        if(i == num){//찾아야 하는 박스가 쌓인 줄 번호
            box_line = line; 
            cout << "box_line : " << box_line << "\n";
        }
        
        if(i % w == 0){//한 층을 다 채우면
            direction = !direction;
        }
    }
    
    while(!box_stack[box_line].empty()){
        if(box_stack[box_line].top() == num){
            answer++;
            cout << box_stack[box_line].top() << "\n";
            break;
        }
        else{
            answer++;
            cout << box_stack[box_line].top() << "\n";
            box_stack[box_line].pop();
        }
    }
    
    return answer;
}