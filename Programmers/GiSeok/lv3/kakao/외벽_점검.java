/**
 * 2020 kakao - 외벽 점검 [실패|03:25:16]
 * lv3, 순열/원형완탐, 시도3
 */
package Programmers.GiSeok.lv3.kakao;

public class 외벽_점검 {

    class Solution {
        static int[] dist, w;
        static int ans;
        static int m;

        public void swap(int idx1, int idx2) {
            int temp = dist[idx1];
            dist[idx1] = dist[idx2];
            dist[idx2] = temp;
        }

        public void perm(int cnt) {

            if (cnt == dist.length) {

                for (int i = 0; i < w.length; i++) {
                    int[] week = makeWeek(w, i, m);
                    int idx = 0;
                    boolean flag = false;
                    int range = week[0] + dist[0];

                    for (int j = 1; j < w.length; j++) {
                        if (week[j] > range) {

                            if (idx + 1 == dist.length) { flag = true; break; }
                            range = week[j] + dist[++idx];
                        }
                    }

                    if (!flag) ans = Math.min(ans, idx + 1);
                }

                return;
            }

            for (int i = cnt; i < dist.length; i++) {
                swap(i, cnt);
                perm(cnt+1);
                swap(i, cnt);
            }
        }

        public int[] makeWeek(int[] w, int start, int n) {

            if (start == 0) return w;

            int[] week = new int[w.length];
            int idx = 0;
            for (int i = start; i < w.length; i++) week[idx++] = w[i];
            for (int i = 0; i < start; i++) week[idx++] = w[i] + n;

            return week;
        }

        public int solution(int n, int[] week, int[] d) {
            ans = Integer.MAX_VALUE;
            dist = d;
            w = week;
            m = n;

            perm(0);

            if (ans == Integer.MAX_VALUE) ans = -1;
            return ans;
        }
    }
}
