package Programmers.Hyeon.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                }
            }
            return stack.isEmpty();
        }
    }
// lv2 올바른 괄호 스택
// 걍 쉽게 풀었다.
}
