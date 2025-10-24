package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_21736 {
    static int N, M;
    static char[][] campus;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    int res = bfs(i, j);
                    System.out.println((res == 0) ? "TT" : res);
                    return;
                }
            }
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
                    continue;
                }
                if (campus[ny][nx] == 'X') {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
                if (campus[ny][nx] == 'P') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
// S2 헌내기는 친구가 필요해 BFS
// 13분
// 그냥 쉽게 조건 걸어서 했다 P 일 때 cnt 하면 된다.