#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0, n = citations.size(), h, i;
    
    //과학자가 발표한 논문의 수 n = citations.size()
    sort(citations.begin(), citations.end());
    for(i = 0; i < n; i++){
        h = n - i; // 현재 인용 횟수 이상의 논문 개수
        if (citations[i] >= h) { // 조건을 만족하면 H-Index 갱신
            answer = h;
            cout << "H-index : " << h << "\n";
            break;
        }
    }
    
    return answer;
}