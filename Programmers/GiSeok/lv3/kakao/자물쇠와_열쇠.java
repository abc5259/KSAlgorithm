/**
 * 2020 kakao - 자물쇠와 열쇠 [성공(반례힌트)|02:03:59]
 * lv3, 완전탐색, 시도6
 */
package Programmers.GiSeok.lv3.kakao;

public class 자물쇠와_열쇠 {

    class Solution {
        int n, m;

        public int[][] rotate(int[][] k) {
            int[][] new_k = new int[m][m];

            for (int ky = 0; ky < m; ky++) {
                for (int kx = 0; kx < m; kx++) {
                    new_k[kx][k.length - ky - 1] = k[ky][kx];
                }
            }

            return new_k;
        }

        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;
            n = lock.length;
            m = key.length;

            int maxX = 0;
            int maxY = 0;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            int cnt = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (lock[y][x] == 0) {
                        maxX = Math.max(maxX, x);
                        maxY = Math.max(maxY, y);
                        minX = Math.min(minX, x);
                        minY = Math.min(minY, y);
                    } else cnt++;
                }
            }

            if (cnt == (n*n)) return true;

            int rangeX = maxX - minX;
            int rangeY = maxY - minY;

            for (int i = 0; i < 4; i++) {

                for (int y = 0; y < m-rangeY; y++) {
                    for (int x = 0; x < m-rangeX; x++) {

                        int my = minY;
                        int mx = minX;
                        boolean flag = true;
                        for (int ky = y; ky <= y + rangeY; ky++) {
                            mx = minX;
                            for (int kx = x; kx <= x + rangeX; kx++) {
                                if ((lock[my][mx] ^ key[ky][kx]) == 0) flag = false;
                                mx++;
                            }
                            my++;
                        }

                        if (flag) answer = true;
                    }
                }

                key = rotate(key);
            }

            return answer;
        }
    }
}
