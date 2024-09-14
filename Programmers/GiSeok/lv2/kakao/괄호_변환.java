/**
 * 2020 kakao - 괄호 변환 [성공|00:23:33]
 * lv2, 문자열/스택, 시도1
 */
package Programmers.GiSeok.lv2.kakao;

import java.util.*;

public class 괄호_변환 {

    class Solution {
        public boolean isCorrect(String p) {
            ArrayDeque<Character> stk = new ArrayDeque<>();

            for (int i = 0; i < p.length(); i++) {

                if (p.charAt(i) == '(') stk.push(p.charAt(i));
                else {
                    if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                    else return false;
                }
            }

            return stk.isEmpty();
        }

        public int equality(String p) {
            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') cnt1++;
                else cnt2++;

                if (cnt1 == cnt2) return i;
            }

            return 0;
        }

        public String go(String p) {

            if (p.isEmpty()) return "";

            int idx = equality(p);
            String u = p.substring(0, idx + 1);
            String v = p.substring(idx+1);

            if (isCorrect(u)) {
                return u + go(v);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(go(v));
                sb.append(")");

                for (int i = 1; i < u.length()-1; i++) {
                    if (u.charAt(i) == '(') sb.append(")");
                    else sb.append("(");
                }

                return sb.toString();
            }
        }

        public String solution(String p) {
            if (isCorrect(p)) return p;
            else return go(p);
        }
    }
}
