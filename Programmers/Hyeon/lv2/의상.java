package Programmers.Hyeon.lv2;

import java.util.HashMap;

public class 의상 {

    class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> map = new HashMap<>();


            for (String[] row : clothes) {
                map.put(row[1], map.getOrDefault(row[1], 0) + 1);
            }

            int answer = 1;

            for (Integer i : map.values()) {
                answer *= (i + 1);
            }

            return answer - 1;
        }
    }
}
// lv2 의상 HashMap
// 10분
// 쉽게 풀었다.
// 가능한 경우의 수 고려해서 아무것도 안입은 거까지해서 각 map의 value 에 +1 씩 해서 누적 곱한다음
// 아무것도 안입은 경우 -1 을 해줘서 구했다 map 의 value 를 통해 가지고 있는 옷들의 개수를 구함.