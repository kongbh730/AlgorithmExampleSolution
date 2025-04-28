#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    int i, first_lowest, second_lowest, next, count = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
        
    //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    for(int temp : scoville){
        pq.push(temp);
    }
    
    while(pq.size() >= 2 && pq.top() < K){
        first_lowest = pq.top();
        pq.pop();
        second_lowest = pq.top();
        pq.pop();
        
        next = first_lowest + (second_lowest * 2);
        pq.push(next);
        
        //cout << first_lowest << " + " << "(" << second_lowest << " * 2) = "<< "next : " << next << "\n";
        
        count++;
    }

    if(pq.size() == 1 && pq.top() < K){
        answer = -1;
    }
    else{
        answer = count;
    }
    
    return answer;
}