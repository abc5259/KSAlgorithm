package Programmers.Hyeon.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {

    class Solution {
        public String solution(int[] numbers) {
            String[] arr = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                arr[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(arr, new Comparator<>() {
                @Override
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });

            if (arr[0].equals("0")) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
}
// lv2 가장 큰 수 정렬
// 30분
// 일단 인상 깊은 점이 s1 과 s2 를 통해서 정렬 알고리즘을 만들 수 있었다
// 303 vs 330 & 343 vs 334 는 합해서 비교할 수 있었다 순서는
// 그리고 테스트케이스에서 0,0,0 으로 주어질 경우 값이 000 이 되는데 이는 0 과 같아야 하므로
// 예외처리를 진행했다.