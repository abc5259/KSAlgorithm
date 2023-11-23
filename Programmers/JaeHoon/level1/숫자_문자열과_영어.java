package Programmers.JaeHoon.level1;

import java.util.*;

public class 숫자_문자열과_영어 {

    class Solution {
        public int solution(String s) {
            String answer = "";
            Map<String, Integer> map = new HashMap<>();
            map.put("zero",0);
            map.put("one",1);
            map.put("two",2);
            map.put("three",3);
            map.put("four",4);
            map.put("five",5);
            map.put("six",6);
            map.put("seven",7);
            map.put("eight",8);
            map.put("nine",9);

            String ss = "";
            for(int i=0; i<s.length(); i++) {
                int n = s.charAt(i) - '0';
                if(n >= 0 && n <= 9) {
                    answer += n;
                    ss = "";
                }
                else {
                    // 문자임
                    ss += s.charAt(i);
                    if(map.containsKey(ss)) {
                        answer += map.get(ss);
                        ss = "";
                    }
                }
            }
            return Integer.parseInt(answer);
        }
    }
}
