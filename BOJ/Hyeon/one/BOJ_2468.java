package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int[][] map;
    static boolean[][] visit;
    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        for (int h = 0; h < max; h++) {
            visit = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            res = Math.max(cnt, res);
        }
        System.out.println(res);
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static void bfs(int y, int x, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N
                        && !visit[ny][nx] && map[ny][nx] > h) {
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
// S1 안전영역 BFS
// 일단 풀었다 bfs 의 규칙적인 풀이를 통해