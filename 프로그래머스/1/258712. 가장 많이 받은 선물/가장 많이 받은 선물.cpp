#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <iostream>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    int i = 0, j = 0;
    vector<vector<int>> gift_count(friends.size(), vector<int> (friends.size(), 0));
    int send, receive, gift_point, have_to_receive;
    map <string, int> gift_points;
    
    //인덱스 생성
    map<string, int> index;
    for(string name : friends){
        index[name] = i;
        i++;
    }
    
    //A B -> A가 B에게 선물을 줌
    for(i = 0; i < gifts.size(); i++){
        string word;
        istringstream ss(gifts[i]);
        vector<string> temp;

        while (ss >> word) {  // 공백을 기준으로 분리
            temp.push_back(word);
        }
       
        gift_count[index[temp[0]]][index[temp[1]]]++;
    }
    
    cout << "선물 주고 받기\n";
    for(auto v : gift_count){
        for(int num : v){
            cout << num << " ";
        }
        cout << "\n";
    }
    
    for(i = 0; i < gift_count.size(); i++){
        send = 0;
        receive = 0;
        have_to_receive = 0;
        
        //선물 지수 구하기
        for(j = 0; j < gift_count[i].size(); j++){
            send += gift_count[i][j];
            receive += gift_count[j][i];    
        }
        gift_point = send - receive;
        gift_points[friends[i]] = gift_point;
        
        cout << "send : " << send << ", receive : " << receive << ", gift_point : " << gift_point << "\n";
    }
    
    cout << "\n선물 지수\n";
    for(auto temp : gift_points){
        cout << temp.first << " " << temp.second << "\n";
    }
    //A가 B에게 준 만큼 돌려 받는데, A와 B가 똑같이 주고 받았다면, 둘의 선물 지수를 비교해서 높은 사람이 받아야 함?
    for(i = 0; i < gift_count.size(); i++){
        have_to_receive = 0;
        for(j = 0; j < gift_count[i].size(); j++){
            if(gift_count[i][j] > gift_count[j][i]){//A가 B에게 더 많이 줬다면?
                have_to_receive++;
            }
            else if(gift_count[i][j] == gift_count[j][i]){//둘이 같은 양을 주고 받았다면?
                if(gift_points[friends[i]] > gift_points[friends[j]]){//선물 지수가 더 크면 받음
                    have_to_receive++;
                }
                else{//선물 지수가 같거나 작으면 패스
                    ;
                }
            }
            else{//A가 B에게 덜 줬다면.
                //패스
            }
        }
        
        if(answer <= have_to_receive){
            answer = have_to_receive;
        }
        cout << friends[i] << "가 받을 선물 : " << have_to_receive << "\n";
    }
    
    return answer;
}