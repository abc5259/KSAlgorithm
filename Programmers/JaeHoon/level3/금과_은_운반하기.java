package Programmers.JaeHoon.level3;

public class 금과_은_운반하기 {
    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long answer = -1;
            long low = 0;
            long high =400000000000000L;

            while(low + 1 < high) {
                long mid = (low + high) / 2;
                if(check(mid,a,b,g,s,w,t)) {
                    high = mid;
                }else {
                    low = mid;
                }
            }
            return high;
        }

        public boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
            int n = s.length;

            long maxMineral = 0;
            long maxSilver = 0;
            long maxGold = 0;
            for(int i=0; i<n; i++) {
                long maxTake = (time / (2 * t[i]));
                if(time % (2 * t[i]) >= t[i]) maxTake++;

                maxTake *= w[i];
                maxMineral += Math.min(g[i] + s[i], maxTake);
                maxSilver += Math.min(s[i], maxTake);
                maxGold += Math.min(g[i], maxTake);
            }

            return maxMineral >= a+b && maxGold >= a && maxSilver >= b;
        }
    }
}
