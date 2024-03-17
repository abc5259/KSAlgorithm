package Programmers.JaeHoon.level3;

import java.util.*;
public class 다단계_칫솔_판매 {

    class Solution {
        Map<String,Integer> map = new HashMap<>();
        int[] parent;
        int[] answer;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            answer = new int[enroll.length];
            parent = new int[enroll.length+1];
            map.put("-", 0);
            for(int i=1; i<=enroll.length; i++) {
                map.put(enroll[i-1], i);
            }
            for(int i=0; i<enroll.length; i++) {
                parent[i+1] = map.get(referral[i]);
            }

            for(int i=0; i<seller.length; i++) {
                int idx = map.get(seller[i]);

                divide(idx, amount[i] * 100);
            }
            return answer;
        }
        public void divide(int idx, int money) {
            if(money == 0) return;

            if(idx == 0) {
                return;
            }

            int next = money / 10;
            answer[idx-1] += money - next;
            divide(parent[idx], next);
        }
    }
}
