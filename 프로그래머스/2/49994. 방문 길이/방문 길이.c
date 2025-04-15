#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* dirs) {
    int answer = 0;
    int current_x = 5, current_y = 5;
    int cx, cy, nx, ny;
    int i;
    bool visited[11][11][11][11] = {{{{false}}}};

    i = 0;
    while(dirs[i] != '\0'){
        
        cx = current_x;
        cy = current_y;
        
        switch (dirs[i]){
            case 'U':
                nx = cx;
                ny = cy - 1;
                break;
            case 'D':
                nx = cx;
                ny = cy + 1;
                break;
            case 'R':
                nx = cx + 1;
                ny = cy;
                break;
            case 'L':
                nx = cx - 1;
                ny = cy;
                break;
            default:
                break;
        }
        if(((nx) >= 0 && (nx) <= 10) &&
           ((ny) >= 0 && (ny) <= 10)){
            if(!visited[cx][cy][nx][ny] && !visited[nx][ny][cx][cy]){//방문한적 없다면
                visited[cx][cy][nx][ny] = true;//방문기록 저장
                visited[nx][ny][cx][cy] = true;//방문기록 저장
                current_x = nx;//현 위치 갱신
                current_y = ny;//현 위치 갱신
                printf("%c, (%d, %d) <-> (%d, %d)\n", dirs[i], cx, cy, nx, ny);
                answer++;
            }
            else{//방문한 적 있다면
                printf("%c, (%d, %d) <-> (%d, %d)\n", dirs[i], cx, cy, nx, ny);
                current_x = nx;//현 위치 갱신 //이동은 함
                current_y = ny;//현 위치 갱신 //이동은 함
            }
        }
        else{//범위를 벗어난 경우
            //기존 위치 유지
            printf("%c (%d, %d) <-> (%d, %d)\n", dirs[i], cx, cy, nx, ny);
        }
        
        i++;
    }
    
    return answer;
}