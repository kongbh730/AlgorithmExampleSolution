#include <string>
#include <vector>
#include <iostream>

using namespace std;

int max_count = 0;

void dfs(int k, vector<vector<int>>& dungeons, vector<bool>& visited, int count) {
    max_count = max(max_count, count); // 최대 던전 개수 갱신
    cout << max_count << "\n";

    for (int i = 0; i < dungeons.size(); i++) {
        if (!visited[i] && k >= dungeons[i][0]) { // 방문 X && 최소 피로도 만족
            visited[i] = true;   // 방문 처리
            dfs(k - dungeons[i][1], dungeons, visited, count + 1); // 탐험 진행
            visited[i] = false;  // 백트래킹 (복구)
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    
    // k = 현재 피로도
    //deongeons[i][0] = 최소 필요 피로도
    //deongeons[i][1] = 소모 피로도
    
    // dungeons.size()만큼의 인덱스 0부터 dungeons.size()-1까지의 조합을 구해서
    // 필요 피로도, 소모 피로도 조건에 맞는 최대 개수 구하기?
    
    vector<bool> visited(dungeons.size(), false); // 방문 체크
    dfs(k, dungeons, visited, 0); // 탐색 시작
    answer = max_count;
    
    return answer;
}