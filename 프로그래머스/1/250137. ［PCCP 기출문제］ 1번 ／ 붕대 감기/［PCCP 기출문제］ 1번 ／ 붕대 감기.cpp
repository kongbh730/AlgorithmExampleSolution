#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int final_attack_time = attacks[attacks.size() - 1][0];
    int current_health = health, serial_heal = 1, attack_index = 0, current_time;
    
    for(current_time = 0; current_time <= final_attack_time; current_time++){
        cout << "현재 시간 : " << current_time << "초\n";
        if(current_time == attacks[attack_index][0]){//지금 공격이 존재하는지?
            cout << "몬스터 공격 -> ";
            current_health = current_health - attacks[attack_index][1];//공격 수행하고 체력 까기
            if(current_health <= 0){//공격 맞고 죽음
                cout << "죽음\n";
                return -1;
            }
            else{//공격 맞고 살지만, 연속 힐 초기화
                cout << "현재 체력 : " << current_health << "\n";
                attack_index++;
                serial_heal = 1;
            }
        }
        else{//공격 존재 안함
            cout << "현재 체력 : " << current_health << " -> ";
            if(current_health >= health){//풀피 인지?
                current_health = health;
                cout << "풀피\n";
                serial_heal = 1;
            }
            else{//회복 가능한지?
                cout << "회복 필요 -> ";
                if(serial_heal == bandage[0])//연속 힐 성공? 연속 힐 초기화
                {
                    cout << "연속 회복 성공 -> ";
                    current_health = current_health + bandage[1] + bandage[2];
                    serial_heal = 1;
                    cout << "현재 체력 : " << current_health << "\n";
                }
                else{//연속 힐 이어가기
                    serial_heal++;
                    current_health = current_health + bandage[1];
                    cout << "현재 체력 : " << current_health << "\n";
                }
            }
        }
    }
    answer = current_health;
    
    return answer;
}