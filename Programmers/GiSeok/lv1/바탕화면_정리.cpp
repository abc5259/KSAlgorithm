#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    // 가장 위에 있는 좌표 찾기
    int maxY;
    for (int i = 0; i < wallpaper.size(); i++) {
        if (wallpaper[i].find('#') != string::npos) {
            maxY = i;
            break;
        }
    }
    
    // 가장 아래에 있는 좌표 찾기
    int minY;
    for (int i = wallpaper.size()-1; i >= 0; i--) {
        if (wallpaper[i].find('#') != string::npos) {
            minY = i;
            break;
        }
    }
    
    // 가장 왼쪽에 있는 좌표 찾기
    int minX = 51;
    for (int i = 0; i < wallpaper.size(); i++) {
        if (wallpaper[i].find('#') != string::npos && minX > wallpaper[i].find('#')) {
            minX = wallpaper[i].find('#');
        }
    }
    
    // 가장 오른쪽에 있는 좌표 찾기
    int maxX = 0;
    for (int i = 0; i < wallpaper.size(); i++) {
        if (wallpaper[i].rfind('#') != string::npos && maxX < wallpaper[i].rfind('#')) {
            maxX = wallpaper[i].rfind('#');
        }
    }
    
    vector<int> answer;
    
    answer.push_back(maxY);
    answer.push_back(minX);
    
    answer.push_back(minY + 1);
    answer.push_back(maxX + 1);
    return answer;
}