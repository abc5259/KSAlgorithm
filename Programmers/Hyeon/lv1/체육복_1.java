package Programmers.Hyeon.lv1;

import java.util.Arrays;
import java.util.HashSet;

public class 체육복_1 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            HashSet<Integer> lostSet = new HashSet<>();
            for (int l : lost) {
                lostSet.add(l);
            }

            HashSet<Integer> reserveSet = new HashSet<>();
            for (int r : reserve) {
                reserveSet.add(r);
            }

            HashSet<Integer> selfControl = new HashSet<>();
            for (int l : lostSet) {
                if (reserveSet.contains(l)) {
                    selfControl.add(l);
                }
            }
            lostSet.removeAll(selfControl);
            reserveSet.removeAll(selfControl);

            int answer = n - lost.length + selfControl.size();

            Arrays.sort(lost);

            for (int l : lost) {
                if (selfControl.contains(l)) {
                    continue;
                }
                if (reserveSet.contains(l - 1)) {
                    reserveSet.remove(l - 1);
                    answer++;
                } else if (reserveSet.contains(l + 1)) {
                    reserveSet.remove(l + 1);
                    answer++;
                }
            }
            return answer;
        }
    }
}
// lv1 체육복 그리디
// 2번째 풀이
// 찾아본 거 중에 HashSet 자료구조를 잘 쓰는 풀이가 있어서 학습 목적
// 일단 Hash 의 경우 배열 처럼 O(1) 접근이 가능하다 사실 SET 말고 List 를 쓰려고 했는데
// 이 차이 때문에 SET 을 썼고 contains 시 판별 할 수 있는 기능과
// 값의 remove 와 set에 대한 메소드에서 removeAll 을 통해 셋에서 셋을 뺄 수 있는 구조였다
// 중복을 제거하기 수월한 코드
// N값이 클수록 효율적