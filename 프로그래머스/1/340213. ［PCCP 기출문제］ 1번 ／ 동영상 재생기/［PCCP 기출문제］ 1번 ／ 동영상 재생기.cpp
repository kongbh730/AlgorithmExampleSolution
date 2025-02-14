#include <string>
#include <vector>
#include <iostream>

using namespace std;

int parse_and_to_sec(string time){
    //mm:ss
    int minute = stoi(time.substr(0, 2));
    int second = stoi(time.substr(3, 2));
    
    return (minute * 60) + second;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    
    /*
    동영상의 길이를 나타내는 문자열 video_len
    기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos
    오프닝 시작 시각을 나타내는 문자열 op_start
    오프닝이 끝나는 시각을 나타내는 문자열 op_end
    사용자의 입력을 나타내는 1차원 문자열 배열 commands
    */
    
    int sec_video_len, sec_pos, sec_op_start, sec_op_end;
    int i, j;
    
    sec_video_len = parse_and_to_sec(video_len);
    sec_pos = parse_and_to_sec(pos);
    sec_op_start = parse_and_to_sec(op_start);
    sec_op_end = parse_and_to_sec(op_end);
    
    cout << "비디오 길이 " << sec_video_len << "\n";
    cout << "비디오 시작 시간 " << sec_pos << "\n";
    cout << "오프닝 시작하는 시간 " << sec_op_start << "\n";
    cout << "오프닝 끝나는 시간 " << sec_op_end << "\n\n";
    
    for(string command : commands){
        //오프닝 구간 확인
        if(sec_pos >= sec_op_start && sec_pos < sec_op_end){
            sec_pos = sec_op_end;
            cout << "오프닝 스킵\n";
        }
        
        if(command == "next"){
            sec_pos += 10;
            if(sec_pos >= sec_video_len){//비디오 길이 넘어가면 비디오 길이로 저장
                sec_pos = sec_video_len;
            }
        }
        else if(command == "prev"){
            sec_pos -= 10;
            if(sec_pos <= 0){//0초 아래로 넘어가면 0초로 저장
                sec_pos = 0;
            }
        }
        else{
            ;
        }
        
        cout << "명령 시행 후 시간 " << sec_pos << "\n";
    }
    
    //마지막 명령 수행 후 오프닝 구간인지 확인
    if(sec_pos >= sec_op_start && sec_pos < sec_op_end){
        sec_pos = sec_op_end;
        cout << "오프닝 스킵\n";
    }
    
    string mm, ss;
    mm = to_string(sec_pos / 60);
    ss = to_string(sec_pos % 60);
    
    if(mm.length() == 1){
        mm = "0" + mm;
    }
    if(ss.length() == 1){
        ss = "0" + ss;
    }
    
    answer = mm + ":" + ss;
    
    return answer;
}