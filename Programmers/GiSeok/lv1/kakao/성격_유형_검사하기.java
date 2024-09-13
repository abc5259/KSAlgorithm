package Programmers.GiSeok.lv1.kakao;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            Map<String, Integer> menu = new HashMap<>();
            String[] category = new String[]{"R", "T", "C", "F", "J", "M", "A", "N"};

            for (String cg: category) {
                menu.put(cg, 0);
            }

            for (int i = 0; i < survey.length; i++) {
                int choice = choices[i]-4;
                if (choice > 0) {
                    menu.put(survey[i].substring(1,2), menu.get(survey[i].substring(1,2)) + choice);
                } else {
                    menu.put(survey[i].substring(0, 1), menu.get(survey[i].substring(0, 1)) + Math.abs(choice));
                }
            }

            for (int i = 0; i < category.length; i+=2) {
                if (menu.get(category[i]) >= menu.get(category[i + 1]))
                    answer += category[i];
                else
                    answer += category[i + 1];
            }

            return answer;
        }
    }
}