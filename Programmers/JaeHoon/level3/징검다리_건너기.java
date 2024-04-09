package Programmers.JaeHoon.level3;

public class 징검다리_건너기 {
    class Solution {
        int[] stone;
        public int solution(int[] stones, int k) {
            stone = stones;
            int answer = 0;
            int high = 200_000_001;
            int low = 1;

            while(low + 1 < high) {
                int mid = (low + high) / 2;
                if(check(mid, k)) {
                    low = mid;
                }else {
                    high = mid;
                }
            }


            return low;
        }

        public boolean check(int cnt, int k) {

            boolean isOk = true;
            int max = 0;
            int passCnt = 0;
            for(int i=0; i<stone.length; i++) {
                if(stone[i] - (cnt - 1) > 0) { //건널수 있음
                    max = Math.max(max, passCnt+1);
                    passCnt = 0;
                    // isOk = true;
                }else { //건널 수 없음
                    if(i + 1 == stone.length) {
                        passCnt+=2;
                    }else {
                        passCnt++;
                    }
                    max = Math.max(max, passCnt);
                }
            }

            return max <= k;
        }
    }
}
