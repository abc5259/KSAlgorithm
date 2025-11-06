package Programmers.JaeHoon.level2;

public class 퍼즐_게임_챌린지 {
  class Solution {
    int[] diffs;
    int[] times;
    long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int low = 0;
        int high = 100000;
        
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                high = mid;
            }else {
                low = mid;
            }
        }
        return high;
    }
    
    public boolean check(int level) {
        long sum = 0;
        int prevTime = 0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level) {
                sum += times[i];
            }else {
                int t = (times[i] + prevTime) * (diffs[i] - level)  + times[i];
                sum += t;
            }
            prevTime = times[i];
        }
        
        return limit >= sum;
    }
}
}
