package Programmers.Hyeon.lv2;

import java.util.*;

public class 귤_고르기 {

    class Solution {
        public int solution(int k, int[] tangerine) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int t : tangerine) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            List<Integer> cnt = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cnt.add(entry.getValue());
            }

            cnt.sort(Collections.reverseOrder());

            int answer = 0;
            int sum = 0;

            for (int v : cnt) {
                sum += v;
                answer++;
                if (sum >= k) {
                    break;
                }
            }
            return answer;
        }
    }
}
// lv2 귤 고르기 HashMap
// 12분
// entrySet 사용함
// 아니 이런건 개 쉽게 풀면서 왜 코테에서는 10분 20분 걸리지,,
// entrySet 사용해서 반환타입 Map.Entry<Key,value> entry 로 해서 entry 에 대한 메소드
// getKey(), getValue() 사용가능