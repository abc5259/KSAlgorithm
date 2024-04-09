package Programmers.JaeHoon.level2;

import java.util.*;
public class 괄호_변환 {

    class Solution {
        public String solution(String p) {
            String answer = "";

            return solve(p);
        }

        public String solve(String p) {
            if(p.equals("")) return "";

            int idx = find(p);
            String u = p.substring(0, idx+1);
            String v = "";
            if(idx != p.length() - 1) {
                v = p.substring(idx+1, p.length());
            }

            String result = "";
            if(check(u)) {
                result += u;
                result += solve(v);
            }else {

                String str = "(";
                str += solve(v);
                str += ")";

                for(int i=1; i<u.length()-1; i++) {
                    if(u.charAt(i) == '(') str += ")";
                    else str += "(";
                }

                result = str;
            }

            return result;

        }

        public boolean check(String u) {

            Stack<Character> stack = new Stack<>();

            for(int i=0; i<u.length(); i++) {

                if(u.charAt(i) == '(') {
                    stack.push('(');
                }else {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }

        public int find(String v) {
            int cnt1 = 0;
            int cnt2 = 0;
            for(int i=0; i<v.length(); i++) {

                if(v.charAt(i) == '(') {
                    cnt1++;
                    if(cnt1 == cnt2) return i;
                }
                else {
                    cnt2++;
                    if(cnt1 == cnt2) return i;
                }
            }

            return v.length() - 1;
        }
    }
}
