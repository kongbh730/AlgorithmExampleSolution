#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0, count = 0, current = 0;
    int i, j;
    int max_size = *max_element(tangerine.begin(), tangerine.end());//반복자 반환이기에 *를 붙임
    //귤을 크기별로 구분해, 총 합이 k개 이면서 종류는 최소인 경우 구하기
    //DP?
    
    //분류
    vector<int> count_tangerine(max_size + 1, 0);
    for(i = 0; i < tangerine.size(); i++){
        count_tangerine[tangerine[i]]++;//tangerine[i] 크기의 귤 개수 추가
    }
    sort(count_tangerine.begin(), count_tangerine.end(), greater<>());
    
    //분류결과
    // for(int temp : count_tangerine){
    //     cout << temp << " ";
    // }
    // cout << "\n";
    
    //k개를 맞추기 위한 종류 최솟값 구하기
    //그리디 알고리즘
    for(i = 0; i < count_tangerine.size(); i++){
        if(count_tangerine[i] + current >= k){
            current += count_tangerine[i];
            count++;
            break;
        }
        else if(count_tangerine[i] + current < k){
            count++;
            current += count_tangerine[i];
        }
        else{
            continue;
        }
    }
    answer = count;
    
    return answer;
}