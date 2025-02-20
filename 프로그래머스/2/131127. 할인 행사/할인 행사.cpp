#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0, count = 0, i, j;
    
    //want : 정현이가 원하는 제품
    //number : 정현이가 원하는 제품 수량
    //discount : 할인하는 제품
    //10일동안만 가능, 할인하는 제품은 하루에 하나씩
    
    for(i = 0; i <= discount.size() - 10; i++){
        //10일간 할인 품목 계산해서 맵에 저장
        map <string, int> discount_list;
        for(j = i; j < i + 10; j++){
            discount_list[discount.at(j)]++;
        }
        
        // cout << i << "일부터 10일간 할인 품목\n";
        // for(auto temp : discount_list){
        //     cout << temp.first << " : " << temp.second << "\n";
        // }
        
        //정현이가 원하는걸 다 구할 수 있는지?
        bool can_buy = true;
        for(j = 0; j < want.size(); j++){
            if(discount_list[want[j]] >= number[j])
            {
                can_buy = true;
            }
            else{
                can_buy = false;
                break;
            }
        }
        if(can_buy){
            //cout << i << "일에 회원가입하면 다 살 수 있음\n";
            count++;
        }
    }
    answer = count;
    
    return answer;
}