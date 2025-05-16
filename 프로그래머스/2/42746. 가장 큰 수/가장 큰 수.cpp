#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int A, int B) {
    string A_str = to_string(A);
    string B_str = to_string(B);
    
    return A_str + B_str > B_str + A_str; // 큰 수가 앞에 오도록
}

string solution(vector<int> numbers) {
    string answer = "";
    
    //가장 앞에 숫자 기준으로 정렬
    sort(numbers.begin(), numbers.end(), compare);
    
    for(int temp : numbers){
        //cout << temp << "\n";
        answer += to_string(temp);
    }
    if(answer[0] == '0'){
        answer = "0";
    }
    
    return answer;
}