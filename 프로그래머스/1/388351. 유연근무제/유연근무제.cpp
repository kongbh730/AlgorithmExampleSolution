#include <string>
#include <vector>
#include <iostream>

using namespace std;

int make_due_time(int time){
    int hour = time / 100;
    int minute = time % 100;
    
    if(minute >= 50){//10분 더했을 때 60을 넘어간다면?
        hour += 1;
        minute = (minute + 10) - 60;
        time = hour * 100 + minute;
    }
    else{
        time += 10;
    }
    //cout << time << "\n";
    
    return time;
}

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int answer = 0;
    int employee_num = schedules.size();
    int i, j;
    int employee_wish_time, today, due_time, count = 0;
    
    //schedules : 출근 희망 시각
    //timelogs : 각 직원 별 일주일 간 출근 시각
    //startday : 이벤트 시작요일 // 금요일이면 5
    
    for(i = 0; i < employee_num; i++){
        count = 0;
        due_time = make_due_time(schedules[i]);
        for(j = 0; j < timelogs[i].size(); j++){
            today = (startday + j) % 7;
            if(today == 0 || today == 6){//토, 일
                count++;
            }
            else{//월, 화, 수, 목, 금
                if(due_time >= timelogs[i][j]){
                    count++;
                }
            }
        }
        
        if(count == timelogs[i].size()){
            answer++;
        }
    }
    
    return answer;
}