#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

//백준 9375 패션왕 신해빈과 동일한 문제
int solution(vector<vector<string>> clothes) {
    int answer = 0, sum;
    map <string, int> assortment;
    int i, j;
    string category;
    
    for(i = 0; i < clothes.size(); i++){
        category = clothes[i][1];
        assortment[category]++;
    }
    
    cout << "분류 결과\n";
    for(auto temp : assortment){
        cout << temp.first << " : " << temp.second << "\n";
    }
    
    //조합의 개수 구하기
    //입거나 안 입는 경우 조합
    sum = 1;
    for(auto temp : assortment){
        sum *= (temp.second + 1);
    }
    cout << sum << "\n";
    answer = sum - 1;
    cout << answer << "\n";
    
    return answer;
}