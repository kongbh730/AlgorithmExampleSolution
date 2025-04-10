#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string word) {
    int answer = 0;
    
    //DFS 또는 완전탐색
    vector<string> words;
    vector<char> alphabet{'A', 'E', 'I', 'O', 'U'};
    int i, j, k, l, m;
    words.push_back("");
    
    for(i = 0; i < alphabet.size(); i++){//A
        string str1 = string(1, alphabet[i]);
        cout << str1 << "\n";
        words.push_back(str1);
        
        for(j = 0; j < alphabet.size(); j++){//AA
            string str2 = str1 + alphabet[j];
            cout << str2 << "\n";
            words.push_back(str2);
            
            for(k = 0; k < alphabet.size(); k++){//AAA
                string str3 = str2 + alphabet[k];
                cout << str3 << "\n";
                words.push_back(str3);
                
                for(l = 0; l < alphabet.size(); l++){//AAAA
                    string str4 = str3 + alphabet[l];
                    cout << str4 << "\n";
                    words.push_back(str4);
                    
                    for(m = 0; m < alphabet.size(); m++){//AAAAA
                        string str5 = str4 + alphabet[m];
                        cout << str5 << "\n";
                        words.push_back(str5);
                    }
                }
            }
        }
    }
    
    for(string str : words){
        if(str == word){
            break;
        }
        answer++;
    }
    
    return answer;
}