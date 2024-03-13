package Programmers.JaeHoon.level2;

import java.util.*;
public class 연속_부분_수열_합의_개수 {

    class Solution {
        public int solution(int[] elements) {
            int answer = 0;

            int n = elements.length;

            Set<Integer> set = new HashSet<>();

            for(int i=0; i<n; i++) {
                set.add(elements[i]);
            }

            for(int len=2; len<=n; len++) {
                int left = 0;
                int right = len-1;

                int sum = 0;
                for(int i=left; i<=right; i++) {
                    sum += elements[i];
                }
                set.add(sum);

                while(left < n) {
                    sum -= elements[left++];
                    right = (right + 1) % n;
                    sum += elements[right];

                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}
