#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, int w, int num) {
    int answer = 0;
    
    while(num <= n) {
        cout << "계산 시작 : " << num << " -> ";
        answer++;
        num += (w - 1 - (w + num - 1) % w) * 2 + 1;
        cout << "계산 끝 : " << num << "\n";
    }
    
    return answer;
}