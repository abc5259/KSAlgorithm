package Programmers.JaeHoon.level2;

import java.math.BigInteger;
import java.util.*;

public class 할인_행사 {

    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < 9; i++) {
                map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            }

            int left = 0;
            int right = 9;

            while (right < discount.length) {
                map.put(discount[right], map.getOrDefault(discount[right], 0) + 1);

                boolean isOk = true;
                for (int i = 0; i < want.length; i++) {
                    if (map.getOrDefault(want[i], 0) < number[i]) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) answer++;

                map.put(discount[left], map.get(discount[left]) - 1);
                left++;
                right++;
            }
            return answer;
        }
    }
}
