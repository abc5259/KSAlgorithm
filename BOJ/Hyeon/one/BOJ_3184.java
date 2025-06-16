package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
    static char[][] map;
    static boolean[][] visit;
    static int R, C, sheep, wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'v') {
                    wolf++;
                } else if (map[i][j] == 'o') {
                    sheep++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int areaWolf = 0, areaSheep = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (map[poll[0]][poll[1]] == 'o') {
                areaSheep++;
            } else if (map[poll[0]][poll[1]] == 'v') {
                areaWolf++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (nx >= 0 && ny >= 0 && nx < C && ny < R && !visit[ny][nx] && map[ny][nx] != '#') {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
        if (areaSheep > areaWolf) {
            wolf -= areaWolf;
        } else {
            sheep -= areaSheep;
        }
    }
}

// S1 양 BFS
