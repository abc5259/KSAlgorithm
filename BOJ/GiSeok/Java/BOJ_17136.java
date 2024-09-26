/**
 * 17136 - 색종이 붙이기 [성공|01:44:10]
 * 골드2, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {

    static int[][] paper;

    static boolean check(int oy, int ox, int n) {

        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                int ny = oy + y;
                int nx = ox + x;
                if (ny < 0 || nx < 0 || ny >= 10 || nx >= 10 || paper[ny][nx] == 0) return false;
            }
        }
        return true;
    }

    static void change(int oy, int ox, int n, int c) {
        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                int ny = oy + y;
                int nx = ox + x;
                paper[ny][nx] = c;
            }
        }
    }

    static int go(int oy, int ox, int[] state) {

        for (int i = 0; i < 5; i++) if (state[i] < 0) return 987654321;

        int cnt = Integer.MAX_VALUE;
        for (int y = oy; y < 10; y++) {
            for (int x = (y > oy) ? 0 : ox; x < 10; x++) {
                if (paper[y][x] == 1) {
                    for (int i = 0; i < 5; i++) {
                        if (check(y, x, i)) {
                            state[i] -= 1;
                            change(y, x, i, 0);
                            cnt = Math.min(cnt, go(y, x, state));
                            change(y, x, i, 1);
                            state[i] += 1;
                        }
                    }
                    return cnt + 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        paper = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) { paper[i][j] = Integer.parseInt(st.nextToken()); }
        }

        int ret = go(0, 0, new int[]{5,5,5,5,5});
        System.out.println((ret >= 987654321) ? -1 : ret);
    }
}
