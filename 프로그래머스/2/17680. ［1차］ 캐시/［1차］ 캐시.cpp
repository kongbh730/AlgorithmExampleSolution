#include <string>
#include <vector>
#include <iostream>
#include <cctype>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    /*
    캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다. 
    -> 횟수가 가장 적은게 아니라 가장 오랫동안 사용되지 않은 거.
    cache hit일 경우 실행시간은 1이다.
    cache miss일 경우 실행시간은 5이다.
    */
    
    int i, j;
    int time = 0;
    vector<pair<string, int>> cache(cacheSize, {"", 0});//캐시 키값, 마지막 사용 이후로 지난 시간
    
    for(i = 0; i < cities.size(); i++){
        if(cacheSize == 0){
            time += 5;
            continue;
        }
        
        string city = cities[i];
        transform(city.begin(), city.end(), city.begin(), ::tolower);

        //cache안에 내가 찾는 게 있는지 찾기 -> cache hit, miss 여부 확인
        bool find_cache_hit = false;
        for(j = 0; j < cache.size(); j++){
            if(city == cache[j].first){
                find_cache_hit = true;
                break;
            }
        }
        
        if(find_cache_hit){//찾음 -> cache hit
            //cout << city << "가 cache내에 존재함! cache hit!\n";
            time += 1;
            
            // 마지막 호출 시간 초기화
            // for(auto cache_data : cache){ //-> 값 수정이 안되는 코드
            //     cache_data.second++;
            // }
            for(auto &cache_data : cache){
                cache_data.second++;
            }
            cache[j].second = 0;
            
            // 초기화 결과
            // for(auto cache_data : cache){
            //     cout << cache_data.first << ", " << cache_data.second << "\n";
            // }
        }
        else{//못 찾음 -> cache miss
            time += 5;
            //cout << city << "가 cache내에 존재하지 않음! cache miss!\n";
            
            // 마지막 호출 시간 초기화
            for(auto &cache_data : cache){
                cache_data.second++;
            }
            
            //어떤 cache를 교체할지?
            int max = 0, max_index = 0;
            bool find_empty_cache = false;
            for(j = 0; j < cache.size(); j++){
                if(cache[j].first == ""){//비어있는 cache 발견
                    cache[j].first = city;
                    cache[j].second = 0;
                    find_empty_cache = true;
                    break;
                }
                else if(cache[j].second > max){//가장 오래전에 호출된 캐시 확인
                    max = cache[j].second;
                    max_index = j;
                }
            }
            if(!find_empty_cache){// 비어있는 cache를 못찾음
                cache[max_index].first = city;
                cache[max_index].second = 0;
            }
            
            // 초기화 결과
            // for(auto cache_data : cache){
            //     cout << cache_data.first << ", " << cache_data.second << "\n";
            // }
        }
        
        //cout << "time : " << time << "\n\n";
    }
    answer = time;
    
    return answer;
}