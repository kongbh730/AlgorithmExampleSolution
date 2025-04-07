#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    int i, j;
    string current_str, compare_str;
    
    sort(phone_book.begin(), phone_book.end());//사전 순 정렬
    // for(string temp : phone_book){
    //     cout << temp << " ";
    // }
    // cout << "\n";
    
    for(i = 0; i < phone_book.size() - 1; i++){
        current_str = phone_book[i];
        // for(j = i + 1; j < phone_book.size(); j++){
        //     compare_str = phone_book[j];
        //     if(compare_str.substr(0, current_str.size()) == current_str){
        //         //cout << current_str << "은 " << compare_str << "의 접두어\n";
        //         return false;
        //     }
        // }
        
        if (phone_book[i + 1].find(phone_book[i]) == 0) {
            return false;
        }
    }
    
    return answer;
}