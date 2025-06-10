package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
    static int w, h;
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> sang;
    static Queue<int[]> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visit = new boolean[h][w];

            sang = new ArrayDeque<>();
            fire = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        sang.offer(new int[]{i, j});
                        visit[i][j] = true;
                    }
                    if (map[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }

            int res = bfs();
            sb.append(res == 0 ? "IMPOSSIBLE" : res).append("\n");
        }
        System.out.print(sb);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int bfs() {
        int time = 0;
        while (!sang.isEmpty()) {

            int size = fire.size();
            while (size-- > 0) {
                int[] poll = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < h && nx < w && map[ny][nx] == '.') {
                        fire.offer(new int[]{ny, nx});
                        map[ny][nx] = '*';
                    }
                }
            }
            size = sang.size();
            while (size-- > 0) {
                int[] poll = sang.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                        return time + 1;
                    }
                    if (map[ny][nx] == '.' && !visit[ny][nx]) {
                        sang.offer(new int[]{ny, nx});
                        visit[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        return 0;
    }
}

// G4 BFS 불
// 2개의 큐를 다뤄서 bfs 하는 문제 불부터 움직이고 사람이 움직인다.
