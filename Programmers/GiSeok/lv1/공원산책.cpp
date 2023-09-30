#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    int startX, startY;
    int H = park.size();
    int W = park[0].length();
    for (int i = 0; i < H; i++) {
        startY = i;
        if (park[i].find('S') != string::npos) {
            startX = park[i].find('S');
            break;
        }
    }
    
    for (string s : routes) {
        int mov = (int)(s[2] - '0');
        
        if (s[0] == 'E') {
            if (startX + mov < W) {
                int flag = false;
                for (int i = startX; i <= (startX + mov); i++) {    
                    if (park[startY][i] == 'X') {
                        flag = true;
                        break;
                    }
                }
                
                if (flag)
                    continue;
                else
                    startX = startX + mov;
            }    
        } else if (s[0] == 'W') {
            if (startX - mov >= 0) {
                int flag = false;
                for (int i = startX; i >= (startX - mov); i--) {    
                    if (park[startY][i] == 'X') {
                        flag = true;
                        break;
                    }
                }
                
                if (flag)
                    continue;
                else
                    startX = startX - mov;
            }    
        } else if (s[0] == 'S') {
            if (startY + mov < H) {
                int flag = false;
                for (int i = startY; i <= (startY + mov); i++) {    
                    if (park[i][startX] == 'X') {
                        flag = true;
                        break;
                    }
                }
                
                if (flag)
                    continue;
                else
                    startY = startY + mov;
            }    
        } else if (s[0] == 'N') {
            if (startY - mov >= 0) {
                int flag = false;
                for (int i = startY; i >= (startY - mov); i--) {    
                    if (park[i][startX] == 'X') {
                        flag = true;
                        break;
                    }
                }
                
                if (flag)
                    continue;
                else
                    startY = startY - mov;
            }    
        }
    }
    
    vector<int> answer;
    answer.push_back(startY);
    answer.push_back(startX);
    return answer;
}