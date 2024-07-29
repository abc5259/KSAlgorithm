/**
 * 14620 - 꽃길 [성공|01:05:12]
 * 실버2, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
    // 시간제한 2초, 메모리제한 256MB
    // 3개의 꽃을 심는 모든 경우의 수를 완전탐색 하면 될듯
    // 6 <= N <= 10 이지만 외곽은 심지 못하므로 실질적으로 8*8과 같다.
    // 그럼 64C3 = 41664

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int ret = Integer.MAX_VALUE;

    static boolean check(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (visited[ny][nx]) return false;
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) return false;
        }

        return true;
    }

    static void flower(int y1, int x1, int total, int cnt) {
        if (cnt == 3) {
            ret = Math.min(ret, total);
            return;
        }

        for (int y = y1; y < N - 1; y++) {
            for (int x = (y1 == y ? x1 + 1 : 1); x < N - 1; x++) {
                if (visited[y][x] || !check(y, x)) continue;

                int sum = map[y][x];
                visited[y][x] = true;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    visited[ny][nx] = true;
                    sum += map[ny][nx];
                }

                flower(y, x, total + sum, cnt + 1);

                visited[y][x] = false;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    visited[ny][nx] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        flower(1, 0, 0, 0);
        System.out.println(ret);
    }
}
