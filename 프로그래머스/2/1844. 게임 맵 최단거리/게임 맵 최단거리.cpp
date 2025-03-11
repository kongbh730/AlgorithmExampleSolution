#include<vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    //최단거리니까 BFS -> queue 사용
    int n = maps.size(), m = maps[0].size();
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    queue <pair<int, pair<int, int>>> q; //이동 횟수, x값, y값
    vector<pair<int, int>> direction{{1, 0},{0, 1},{-1, 0},{0, -1}};//x값 y값
    int i, j;
    int current_x, current_y, next_x, next_y, current_count;
    
    //bfs
    q.push({1, {0, 0}});
    visited[0][0] = true;
    
    while(!q.empty()){
        current_x = q.front().second.first;
        current_y = q.front().second.second;
        current_count = q.front().first;
        q.pop();
        for(i = 0; i < direction.size(); i++){
            next_x = current_x + direction[i].first;
            next_y = current_y + direction[i].second;
            
            if((next_x >= 0 && next_x < m) && (next_y >= 0 && next_y < n) 
               && maps[next_y][next_x] == 1 && !visited[next_y][next_x]){
                if(next_x == m - 1 && next_y == n - 1){
                    return current_count + 1;
                }
                visited[next_y][next_x] = true;
                q.push({current_count + 1, {next_x, next_y}});
            }
        }
    }
    answer = -1;
    
    return answer;
}