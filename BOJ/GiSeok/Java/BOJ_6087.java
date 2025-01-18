/**
 * [G3 다익스트라] 레이저 통신 - O, 01:21:41
 * 시도 4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_6087 {

    private static final int[] DY = {-1, 1, 0, 0};
    private static final int[] DX = {0, 0, -1, 1};

    private static char[][] map;
    private static int w, h;

    private static class DirAndMirror {
        int mirror;
        int dir;

        public DirAndMirror(int mirror, int dir) {
            this.mirror = mirror;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        map = new char[h][w];
        for (int y = 0; y < h; y++) {
            String m = br.readLine();
            for (int x = 0; x < w; x++) {
                map[y][x] = m.charAt(x);
                if (map[y][x] == 'C') {
                    q.offer(y);
                    q.offer(x);
                }
            }
        }

        int startY = q.poll();
        int startX = q.poll();
        map[startY][startX] = '.';
        DirAndMirror[][] shortest1 = new DirAndMirror[h][w];
        DirAndMirror[][] shortest2 = new DirAndMirror[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                shortest1[i][j] = new DirAndMirror(987654321, -2);
            }
        }
        shortest1[startY][startX] = new DirAndMirror(0, 1);
        dijkstra(startY, startX, shortest1);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                shortest2[i][j] = new DirAndMirror(987654321, -2);
            }
        }
        shortest2[startY][startX] = new DirAndMirror(0, 0);
        dijkstra(startY, startX, shortest2);

        int endY = q.poll();
        int endX = q.poll();

        int ret = Math.min(shortest1[endY][endX].mirror, shortest2[endY][endX].mirror);
        System.out.println(ret);
    }

    private static void dijkstra(int y, int x, DirAndMirror[][] shortest) {
        boolean[][] visited = new boolean[h][w];

        while (true) {
            int value = Integer.MAX_VALUE;
            int smallY = 0;
            int smallX = 0;
            for (int yy = 0; yy < h; yy++) {
                for (int xx = 0; xx < w; xx++) {
                    if (!visited[yy][xx] && shortest[yy][xx].mirror < value) {
                        value = shortest[yy][xx].mirror;
                        smallY = yy;
                        smallX = xx;
                    }
                }
            }

            if (map[smallY][smallX] == 'C') break;
            visited[smallY][smallX] = true;

            for (int i = 0; i < 4; i++) {
                int ny = smallY + DY[i];
                int nx = smallX + DX[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (visited[ny][nx] || map[ny][nx] == '*') continue;

                if (shortest[smallY][smallX].dir == 0) {
                    if ((i == 0 || i == 1) && shortest[ny][nx].mirror > shortest[smallY][smallX].mirror) {
                        shortest[ny][nx].mirror = shortest[smallY][smallX].mirror;
                        shortest[ny][nx].dir = 0;
                    } else if ((i == 2 || i == 3) && shortest[ny][nx].mirror > shortest[smallY][smallX].mirror + 1) {
                        shortest[ny][nx].mirror = shortest[smallY][smallX].mirror + 1;
                        shortest[ny][nx].dir = 1;
                    }
                } else if (shortest[smallY][smallX].dir == 1) {
                    if ((i == 0 || i == 1) && shortest[ny][nx].mirror > shortest[smallY][smallX].mirror + 1) {
                        shortest[ny][nx].mirror = shortest[smallY][smallX].mirror + 1;
                        shortest[ny][nx].dir = 0;
                    } else if ((i == 2 || i == 3) && shortest[ny][nx].mirror > shortest[smallY][smallX].mirror) {
                        shortest[ny][nx].mirror = shortest[smallY][smallX].mirror;
                        shortest[ny][nx].dir = 1;
                    }
                }
            }
        }
    }
}
