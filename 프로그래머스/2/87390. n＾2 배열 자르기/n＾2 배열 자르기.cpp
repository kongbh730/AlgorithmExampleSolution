#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    //int i, j, count = 0, num;
    
//     for(i = 1; i <= n; i++){
//        for(j = 1; j <= n; j++){
//            if(j <= i){
//                num = i;
//            }
//            else{
//                num = j;
//            }
           
//            if(count >= left){
//                answer.push_back(num);
//            }
//            if(count == right){
//                //answer.push_back(num);
//                 return answer;
//            }
           
//            count++;
//        }
//     }
    
    // 0 1 2 3 4 5 6 7 8 
    long long t;
    int r, c;
    
    for(t = left; t <= right; t++){
        r = t / n + 1;
        c = t % n + 1;
        //cout << r << ", " << c << " : " << max(r, c) << "\n";
        answer.push_back(max(r, c));
    }
    
    return answer;
}