/**
 * [G1 구현/DFS] 미네랄 - O(반례힌트), 02:57:44
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소 문제?
// 미네랄 깨고나서 해당 높이보다 높은 곳의 연결 요소들의 최소 높이를 구한다.
// 깬 높이보다 최소 높이가 더 높다면? -> 중력으로 내려와야 할 대상
public class BOJ_2933 {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] cave;
    private static boolean[][] visited;
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        cave = new int[r+1][c];
        for (int y = r; y >= 1; y--) {
            String map = br.readLine();
            for (int x = 0; x < c; x++) {
                if (map.charAt(x) == '.') cave[y][x] = 0;
                else cave[y][x] = 1;
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[r+1][c];
            if (i % 2 != 0) { // left
                for (int x = 0; x < c; x++) {
                    if (cave[m][x] != 0) {
                        cave[m][x] = 0;
                        break;
                    }
                }
            } else {
                for (int x = c-1; x >= 0; x--) {
                    if (cave[m][x] != 0) {
                        cave[m][x] = 0;
                        break;
                    }
                }
            }

            for (int x = 0; x < c; x++) {
                if (cave[1][x] != 0 && !visited[1][x]) dfs(1, x, 1);
            }

            int mark = 2;
            for (int y = 1; y <= r; y++) {
                for (int x = 0; x < c; x++) {
                    if (cave[y][x] != 0 && !visited[y][x]) dfs(y, x, mark++);
                }
            }

            for (int mk = 2; mk < mark; mk++) {
                int fallHeight = r;
                for (int y = 1; y <= r; y++) {
                    for (int x = 0; x < c; x++) {
                        if (cave[y][x] == mk) {
                            boolean flag = true;
                            int tmp = r;
                            for (int yy = y - 1; yy >= 1; yy--) {
                                if (cave[yy][x] == mk) { flag = false; break; }
                                if (cave[yy][x] != 0) {
                                    tmp = y - yy - 1;
                                    break;
                                }
                                if (yy == 1 && cave[yy][x] == 0) {
                                    tmp = y - 1;
                                }
                            }

                            if (flag && fallHeight > tmp) {
                                fallHeight = tmp;
                            }
                        }
                    }
                }

                for (int yy = 1; yy <= r; yy++) {
                    for (int x = 0; x < c; x++) {
                        if (cave[yy][x] == mk) {
                            cave[yy - fallHeight][x] = cave[yy][x];
                            cave[yy][x] = 0;
                        }
                    }
                }
            }
        }

        for (int y = r; y >= 1; y--) {
            for (int x = 0; x < c; x++) {
                System.out.print(cave[y][x] == 0 ? '.' : 'x');
            }
            System.out.println();
        }
    }

    private static void dfs(int y, int x, int mark) {
        visited[y][x] = true;
        cave[y][x] = mark;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny <= 0 || ny > r || nx < 0 || nx >= c || visited[ny][nx]) continue;
            if (cave[ny][nx] == 0) continue;

            dfs(ny, nx, mark);
        }
    }
}
