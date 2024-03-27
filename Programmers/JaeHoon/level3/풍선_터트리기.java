package Programmers.JaeHoon.level3;

public class 풍선_터트리기 {
    class Solution {
        public int solution(int[] a) {
            int answer = 1;
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int i=0; i<a.length; i++) {
                if(a[i] < min) {
                    min = a[i];
                    minIdx = i;
                }
            }

            min = Integer.MAX_VALUE;
            for(int i=0; i<minIdx; i++) {
                if(a[i] > min) continue;
                answer++;
                min = Math.min(a[i], min);
            }
            min = Integer.MAX_VALUE;
            for(int i=a.length-1; i>minIdx; i--) {
                if(a[i] > min) continue;
                answer++;
                min = Math.min(a[i], min);
            }
            return answer;
        }
    }
}
