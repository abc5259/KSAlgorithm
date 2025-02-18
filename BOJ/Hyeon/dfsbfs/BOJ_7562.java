package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            len = Integer.parseInt(br.readLine());
            visit = new boolean[len][len]; // 방문여부
            chess = new int[len][len]; // 좌표

            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            if (fx == tx && fy == ty) {
                sb.append(0).append("\n");
                continue;
            }
            bfs(fy, fx);

            sb.append(chess[ty][tx]).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dx = {1, -1, 1, -1, 2, -2, 2, -2};
    static int len;
    static int tx, ty;
    static boolean[][] visit;
    static int[][] chess;

    static void bfs(int r, int c) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int y = arr[0];
            int x = arr[1];
            if (tx == x && ty == y) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < len && nx < len && !visit[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    chess[ny][nx] = chess[y][x] + 1;
                }
            }
        }
    }
}

//S1 나이트의 이동 BFS
// 백트래킹 문제인줄알고 한참 고민했는데 그냥 너비를 탐색해서 이전 횟수를 누적해서 더해주는 chess 배열과
// 방문 여부를 확인할 수 있는 visit을 이용한 기본 문제
// 8방 탐색이다. 나이트는 8군데를 갈 수 있다.