/**
 * 15683 - 감시 [성공|00:49:18]
 * 골드3, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {
    // 시간제한 1초, 메모리제한 512MB
    // 1*1 크기의 정사각형으로 나누어진 M*N 크기의 사무실
    // 사무실에는 K개의 CCTV, CCTV는 5종류
    // CCTV는 바라보는 방향에 칸 전체를 감시할 수 있음. 단, 벽 통과x
    // 적절히 조절해서 사각지대를 최소로 만들자.
    // 1 <= N, M <= 8
    // CCTV <= 8

    // 범위부터 완탐 같음
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int[][] map;
    static int n, m;
    static int ret = Integer.MAX_VALUE;

    static ArrayList<Pair> cctv = new ArrayList<>();

    static ArrayList<Pair> watch(int idx, int dir) {

        ArrayList<Pair> path = new ArrayList<>();

        int y = cctv.get(idx).y;
        int x = cctv.get(idx).x;

        if (map[y][x] == 1) {

            while (true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 6) break;

                if (map[ny][nx] == 0) {
                    map[ny][nx] = 7;
                    path.add(new Pair(nx, ny));
                }

                y = ny;
                x = nx;
            }
        } else if (map[y][x] == 2) {

            for (int i = 0; i <= 2; i+=2) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 6) break;

                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 7;
                        path.add(new Pair(nx, ny));
                    }

                    _y = ny;
                    _x = nx;
                }
            }
        } else if (map[y][x] == 3) {
            for (int i = 0; i < 2; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 6) break;

                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 7;
                        path.add(new Pair(nx, ny));
                    }

                    _y = ny;
                    _x = nx;
                }
            }
        } else if (map[y][x] == 4) {
            for (int i = 0; i < 3; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[(dir + i) % 4];
                    int nx = _x + dx[(dir + i) % 4];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 6) break;

                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 7;
                        path.add(new Pair(nx, ny));
                    }

                    _y = ny;
                    _x = nx;
                }
            }
        } else if (map[y][x] == 5) {
            for (int i = 0; i < 4; i++) {
                int _y = y;
                int _x = x;
                while (true) {
                    int ny = _y + dy[i];
                    int nx = _x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 6) break;

                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 7;
                        path.add(new Pair(nx, ny));
                    }

                    _y = ny;
                    _x = nx;
                }
            }
        }

        return path;
    }

    static void go(int idx) {

        if (idx == cctv.size()) {
            // 사각지대 구하기
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }

            ret = Math.min(ret, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            ArrayList<Pair> path = watch(idx, i);
            go(idx + 1);
            for (Pair p : path) map[p.y][p.x] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) cctv.add(new Pair(j, i));
            }
        }

        go(0);

        System.out.println(ret);
    }
}
