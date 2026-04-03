package Programmers.Hyeon.lv1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            Set<Integer> possible = new HashSet<>();

            for (int part : nums) {
                possible.add(part);
            }

            return Math.min(possible.size(), nums.length / 2);
        }
    }
}
// lv1 폰켓몬 HashSet
// 5분
// 근야 풀었다. 이게 무조건 nums의 절반이 최대인데 possible에 종류한정으로 넣을 경우
// size 가 더 적어서 size 와 절반의 min 값을 리턴받음