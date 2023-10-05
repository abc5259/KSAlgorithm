#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    std::stack<char> stk;
    stk.push(s[0]);
    for (int i = 1; i < s.length(); i++) {
        if (!stk.empty()) {
            if (stk.top() == '(' && s[i] == ')')
                stk.pop();
            else
                stk.push(s[i]);
        } else
            stk.push(s[i]);
    }
    
    bool answer;
    if (stk.empty())
        answer = true;
    else
        answer = false;

    return answer;
}
