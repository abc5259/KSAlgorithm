package Programmers.JaeHoon.level2;

import java.util.*;
public class 튜플 {

    class Solution {
        public int[] solution(String s) {
            s = s.substring(2, s.length() -2);
            String[] arr = s.split("\\},\\{");
            List<String[]> list = new ArrayList<>();
            for(String str: arr) {
                String[] strArr = str.split(",");
                list.add(strArr);
            }
            Collections.sort(list, (a,b) -> a.length - b.length);
            int[] answer = new int[list.get(list.size() - 1).length];
            Set<String> set = new HashSet<>();

            int idx = 0;
            for(String[] tuple: list) {
                Set<String> set2 = new HashSet<>();
                for(String item: tuple) {
                    if(set.contains(item) && !set2.contains(item)){
                        set2.add(item);
                        continue;
                    }

                    set.add(item);
                    answer[idx++] = Integer.parseInt(item);
                }
            }
            return answer;
        }
    }
}
