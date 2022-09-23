package Programmers.GiSeok;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class KAKAO_성격_유형_검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            Map<String, Integer> menu = new HashMap<>();
            String[] category = new String[]{"R", "T", "C", "F", "J", "M", "A", "N"};
            int[] MBTI = new int[8];

            for (int i = 0; i < survey.length; i++) {
                if (choice[i] - 4 > 0) {
                    if (!menu.containsKey(survey[i].substring(1, 2))) {
                        menu.put(survey[i].substring(1,2), choice[i] - 4);
                    } else {
                        menu.put(survey[i].substring(1,2), menu.get(survey[i].substring(1,2)) + (choice[i] - 4));
                    }
                } else {
                    if (!menu.containsKey(survey[i].substring(0, 1))) {
                        menu.put(survey[i].substring(0, 1), Math.abs(choice[i] - 4));
                    } else {
                        menu.put(survey[i].substring(0, 1), menu.get(survey[i].substring(0, 1)) + Math.abs(choice[i] - 4));
                    }
                }
            }

            for (String key : menu.keySet()) {
                MBTI[Arrays.asList(category).indexOf(key)] = menu.get(key);
            }

            for (int i = 0; i < MBTI.length; i+=2) {
                if (MBTI[i] >= MBTI[i + 1]) {
                    answer += category[i];
                } else {
                    answer += category[i + 1];
                }
            }

            return answer;
        }
    }
}