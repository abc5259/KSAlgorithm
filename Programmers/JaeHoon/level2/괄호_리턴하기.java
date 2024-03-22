package Programmers.JaeHoon.level2;

import java.util.*;
public class 괄호_리턴하기 {

    class Solution {
        public int solution(String s) {
            int answer = 0;
            int start = 0;
            while(start < s.length()) {
                Stack<Character> stack = new Stack<>();
                boolean isOk = true;
                for(int i=start; i<s.length(); i++) {
                    if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                        stack.push(s.charAt(i));
                    }
                    else if(s.charAt(i) == '}') {
                        if(stack.isEmpty() || stack.peek() != '{') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                    else if(s.charAt(i) == ')') {
                        if(stack.isEmpty() ||stack.peek() != '(') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                    else if(s.charAt(i) == ']') {
                        if(stack.isEmpty() ||stack.peek() != '[') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                }

                for(int i=0; i<start; i++) {
                    if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                        stack.add(s.charAt(i));
                    }
                    else if(s.charAt(i) == '}') {
                        if(stack.isEmpty() ||stack.peek() != '{') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                    else if(s.charAt(i) == ')') {
                        if(stack.isEmpty() ||stack.peek() != '(') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                    else if(s.charAt(i) == ']') {
                        if(stack.isEmpty() ||stack.peek() != '[') {
                            isOk = false;
                            break;
                        }
                        stack.pop();
                    }
                }

                if(isOk && stack.isEmpty()) answer++;

                start++;
            }

            return answer;
        }
    }
}
