package Programmers.JaeHoon.level2;

import java.util.*;
public class 롤케이크_자르기 {

    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            int[] toppingCnt = new int[10001];
            Set<Integer> toppingSet = new HashSet<>();
            for(int i=0; i<topping.length; i++) {
                toppingCnt[topping[i]]++;
                toppingSet.add(topping[i]);
            }

            Set<Integer> leftCntSet = new HashSet<>();
            int rightCnt = toppingSet.size();

            for(int i=0; i<topping.length-1; i++) {
                leftCntSet.add(topping[i]);
                toppingCnt[topping[i]] -= 1;

                if(toppingCnt[topping[i]] == 0) rightCnt--;

                if(leftCntSet.size() == rightCnt) answer++;
            }

            return answer;
        }
    }
}
