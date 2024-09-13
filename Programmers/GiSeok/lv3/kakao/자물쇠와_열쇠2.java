/**
 * 2020 kakao - 자물쇠와 열쇠 [성공(반례힌트)|02:03:59]
 * lv3, 완전탐색, 시도6
 */
package Programmers.GiSeok.lv3.kakao;

public class 자물쇠와_열쇠2 {
    class Solution {
        static int n, m;

        public int[][] rotate(int[][] k) {
            int[][] new_k = new int[m][m];

            for (int ky = 0; ky < m; ky++) {
                for (int kx = 0; kx < m; kx++) {
                    new_k[kx][k.length - ky - 1] = k[ky][kx];
                }
            }

            return new_k;
        }

        public boolean check(int[][] lk) {

            for (int i = n; i < n + n; i++) {
                for (int j = n; j < n + n; j++) {
                    if (lk[i][j] == 0) return false;
                }
            }

            return true;
        }

        public boolean solution(int[][] key, int[][] lock) {
            n = lock.length;
            m = key.length;

            int cnt = 0;
            for (int y = 0; y < n; y++)
                for (int x = 0; x < n; x++)
                    if (lock[y][x] == 1) cnt++;
            if (cnt == (n*n)) return true;

            int[][] copy = new int[3*n][3*n];
            for (int i = 0; i < n*3; i++)
                for (int j = 0; j < n*3; j++)
                    copy[i][j] = 0;
            for (int i = n; i < n + n; i++)
                for (int j = n; j < n + n; j++)
                    copy[i][j] = lock[i - n][j - n];

            for (int i = 0; i < 4; i++) {

                for (int y = n - m + 1; y < n + n; y++) {
                    for (int x = n - m + 1; x < n + n; x++) {

                        for (int my = 0; my < m; my++)
                            for (int mx = 0; mx < m; mx++)
                                copy[y + my][x + mx] ^= key[my][mx];

                        if (check(copy)) return true;

                        for (int my = 0; my < m; my++)
                            for (int mx = 0; mx < m; mx++)
                                copy[y + my][x + mx] ^= key[my][mx];
                    }
                }

                key = rotate(key);
            }

            return false;
        }
    }
}
