#include <string>
#include <vector>
#include <iostream>

using namespace std;

string pos_check(string pos, string op_start, string op_end){
    if(op_start<=pos && pos <= op_end){
        pos = op_end; 
    }
    return pos;
}


string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    
    for(int i=0; i<commands.size(); i++){
        pos = pos_check(pos, op_start, op_end);
        
        int i_min = (pos[0]-'0')*10+(pos[1]-'0');
        int i_sec = (pos[3]-'0')*10+(pos[4]-'0');
        int len_min = (video_len[0]-'0')*10+(video_len[1]-'0');
        int len_sec = (video_len[3]-'0')*10+(video_len[4]-'0');
        
        if(commands[i]=="next"){
            i_sec = (i_sec+10)%60; 
            if(i_sec<10) i_min += 1;
            
            if(i_min>=len_min&&i_sec>len_sec){
                i_sec = len_sec;
                i_min = len_min;
            }
        }else{ //prev
            if(i_min==0&&i_sec<10){
                pos ="00:00";
                continue;
            }
            
            if(i_sec<10){
                i_sec+=60;
                i_sec = (i_sec-10)%60;
                i_min -=1;
            }
            else i_sec = (i_sec-10)%60;
        }
        
        string minute = "";
        string sec ="";
        if(i_min < 10){
            minute = '0' + to_string(i_min);
        }else{
            minute = to_string(i_min);
        }
        if(i_sec < 10){
            sec = '0' + to_string(i_sec);
        }else{
            sec = to_string(i_sec);
        }
        pos = minute + ":" + sec;        
    }
    pos = pos_check(pos, op_start, op_end);
    
    answer = pos;
      
    return answer;
}