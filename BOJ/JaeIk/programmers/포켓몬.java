package BOJ.JaeIk.programmers;

import java.util.*;

class 포켓몬 {
    public int solution(int[] nums) {
        int max = nums.length/2;
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int answer = (set.size() < max)?set.size():max;

        return answer;

    }
}