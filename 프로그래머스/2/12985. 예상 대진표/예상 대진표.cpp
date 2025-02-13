#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0, temp;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    //cout << "Hello Cpp" << endl;
    
    //A가 더 앞 번호가 되게 하기
    if(a > b){
        temp = a;
        a = b;
        b = temp;
    }
    
    //부전승 없음
    while(true){
        //a가 이겨서 a 갱신
        if(a % 2 == 0){
            a = a / 2;
        }
        else{
            a = (a + 1) / 2;
        }
        //cout << "다음 A는 " << a;
        
        //b가 이겨서 b 갱신
        if(b % 2 == 0){
            b = b / 2;
        }
        else{
            b = (b + 1) / 2;
        }
        
        answer++;
        //cout << " 다음 B는 " << b << " answer : " << answer << "\n";
        
        if(a == b){
            break;
        }
    }

    return answer;
}