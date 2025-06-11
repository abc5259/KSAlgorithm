package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> fire;
    static Queue<int[]> man;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        fire = new ArrayDeque<>();
        man = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (tmp[j] == 'J') {
                    man.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
                if (tmp[j] == 'F') {
                    fire.offer(new int[]{i, j});
                }
                map[i][j] = tmp[j];
            }
        }
        int res = bfs();

        if (res == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(res);
        }
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int bfs() {
        int time = 0;
        while (!man.isEmpty()) {
            int size = fire.size();

            while (size-- > 0) {
                int[] poll = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != '#' && map[ny][nx] != 'F') {
                        fire.offer(new int[]{ny, nx});
                        map[ny][nx] = 'F';
                    }
                }
            }
            size = man.size();

            while (size-- > 0) {
                int[] poll = man.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                        return time + 1;
                    }

                    if (map[ny][nx] == '.' && !visit[ny][nx]) {
                        man.offer(new int[]{ny, nx});
                        visit[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        return 0;
    }
}

// G3 BFS 불!
// 불이랑 같은 개념문제 재밌게 풀었다.
