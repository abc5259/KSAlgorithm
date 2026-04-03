package Programmers.Hyeon.lv2;

import java.util.HashSet;
import java.util.Set;

public class 전화번호_목록_1 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Set<String> set = new HashSet<>();

            for (String s : phone_book) {
                set.add(s);
            }

            for (String s : phone_book) {
                for (int i = 1; i < s.length(); i++) {
                    if (set.contains(s.substring(0, i))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

// lv2 전화번호 목록 HashSet
// 개선 풀이
// Set 을 이용해서 넣으면 O(N)이고 거기에 O(N)에다가 s 의 길이 즉 20만큼 반복해서 전체까지는 다안하고 마지막 만 제외해서
// substring 으로 접두 문자열을 만들어서 이것이 set 에 있는지 판단
// 근데 나는 contains가 최악이 100만이 생각했어서 O(N^2) 라고 생각했는데
// contains 가 1로 가능.
// 최악의 해쉬 충돌이 레드블랙트리로 변환돼서 log n 으로 방어