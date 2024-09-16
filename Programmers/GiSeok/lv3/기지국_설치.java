/**
 * lv3 - 기지국 설치 [실패]
 * 그리디, 시도1
 */
package Programmers.GiSeok.lv3;

public class 기지국_설치 {

    class Solution {

        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            int ret = 0;
            int prev = 0;

            for (int i = 0; i < stations.length; i++) {
                int range = stations[i] - w - 1 - prev;
                int b = (int)((double)range / (double)(w * 2 + 1));
                if ((double)range % (double)(w * 2 + 1) > 0.0) b += 1;

                ret += Math.max(0, b);
                prev = stations[i] + w;
            }

            int b = (int)((double)(n - prev) / (double)(w * 2 + 1));
            if ((double)(n - prev) % (double)(w * 2 + 1) > 0.0) b += 1;
            ret += b;

            return ret;
        }
    }
}
