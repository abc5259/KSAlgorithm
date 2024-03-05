package Programmers.JaeHoon.level2;

import java.util.Arrays;

public class 귤_고르기 {

    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            int[] map = new int[10000001];

            for(int i=0; i<tangerine.length; i++) {
                map[tangerine[i]]++;
            }

            Arrays.sort(map);

            for(int i=10000000; i>=0; i--) {
                if(k <= 0) break;
                if(map[i] == 0) break;

                k -= map[i];
                answer++;
            }
            return answer;
        }
    }
}
