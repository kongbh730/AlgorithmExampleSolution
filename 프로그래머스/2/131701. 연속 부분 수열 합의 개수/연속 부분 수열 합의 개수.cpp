#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    set<int> sums;
    int n = elements.size();
    int length, start, sum = 0, i;

    // 길이 1부터 n까지의 부분 수열 합 구하기
    for (length = 1; length <= n; length++) { 
        for (start = 0; start < n; start++) { // 시작점 설정
            sum = 0;
            // 부분 수열의 합 구하기
            for (i = 0; i < length; i++) { 
                sum += elements[(start + i) % n]; // 원형이므로 % n 사용
            }
            sums.insert(sum);
            //cout << sum << " ";
        }
    }
    answer = sums.size(); // 서로 다른 합의 개수 반환
    
    return answer;
}