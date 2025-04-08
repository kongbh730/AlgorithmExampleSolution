#include <string>
#include <vector>
#include <iostream>
#include <set>
#include <map>

using namespace std;

int solution(vector<int> topping) {
    int answer = -1;
    int i, j, count = 0;
    
    /*
    for(i = 0; i < topping.size() - 1; i++){
        set <int> A;
        set <int> B;
        
        for(j = 0; j <= i; j++){
            A.insert(topping[j]);
        }
        for(j = i + 1; j < topping.size(); j++){
            B.insert(topping[j]);
        }
        
        //cout << A.size() << " : " << B.size() << "\n";
        if(A.size() == B.size()){
            count++;
        }
    }
    answer = count;
    */
    
    set <int> A;
    map<int, int> B;
    int current_topping;
    
    for(i = 0; i < topping.size(); i++){
        B[topping[i]]++;
    }
    
    for (i = 0; i < topping.size() - 1; i++) {
        current_topping = topping[i];

        // 왼쪽에 토핑 추가
        A.insert(current_topping);

        // 오른쪽에서 토핑 수 갱신
        B[current_topping]--;
        
        // 오른쪽에서 제거
        if (B[current_topping] == 0) {
            B.erase(current_topping);
        }

        // 같으면 카운트
        //cout << A.size() << " : " << B.size() << "\n";
        if (A.size() == B.size()) {
            count++;
        }
    }
    answer = count;
    
    return answer;
}