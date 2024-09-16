/**
 * lv3 - 기지국 설치 [실패]
 * 그리디, 시도1
 */
package Programmers.GiSeok.lv3;

import java.util.*;
public class 기지국_설치_2 {

    class Solution {

        static class Pair {
            int s, e;
            Pair(int s, int e) {
                this.s = s;
                this.e = e;
            }
        }

        public int solution(int n, int[] stations, int w) {
            int ans = 0;

            ArrayList<Pair> not = new ArrayList<>();
            if (stations[0] - w > 1) not.add(new Pair(1, stations[0] - w));
            for (int i = 0; i < stations.length - 1; i++) {
                if (stations[i] + w + 1 < stations[i + 1] - w)
                    not.add(new Pair(stations[i] + w + 1, stations[i + 1] - w));
            }

            if (stations[stations.length-1] + w + 1 <= n)
                not.add(new Pair(stations[stations.length-1] + w + 1, n + 1));

            for (int i = 0; i < not.size(); i++) {
                Pair p = not.get(i);
                int range = p.e - p.s;

                if (range <= w * 2 + 1) ans += 1;
                else {
                    ans += (range / (w * 2 + 1));
                    if (range % (w * 2 + 1) != 0) ans += 1;
                }
            }

            return ans;
        }
    }
}
