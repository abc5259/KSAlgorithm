/**
 * 2020 kakao - 문자열 압축 [성공|00:19:01]
 * lv2, 문자열, 시도1
 */
package Programmers.GiSeok.lv2.kakao;

import java.util.*;
public class 문자열_압축 {

    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;

            for (int n = 1; n <= s.length(); n++) {
                ArrayList<String> list = new ArrayList();

                for (int i = 0; i < s.length(); i+=n) {
                    if (i + n >= s.length()) list.add(s.substring(i));
                    else list.add(s.substring(i, i+n));
                }

                StringBuilder ans = new StringBuilder();
                int cnt = 1;
                for (int i = 0; i < list.size()-1; i++) {
                    if (list.get(i).equals(list.get(i + 1)))
                        cnt++;
                    else {
                        if (cnt > 1) ans.append(cnt + list.get(i));
                        else ans.append(list.get(i));
                        cnt = 1;
                    }
                }

                if (cnt > 1) ans.append(cnt + list.get(list.size()-1));
                else ans.append(list.get(list.size()-1));

                answer = Math.min(answer, ans.length());
            }

            return answer;
        }
    }
}
