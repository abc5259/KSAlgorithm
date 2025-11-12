package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16948 {
    static int N;
    static int[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        chess = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(chess[i], -1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        bfs(r1, c1, r2, c2);

        System.out.println(chess[r2][c2]);
    }

    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    static void bfs(int y, int x, int desY, int desX) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        chess[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cy = poll[0];
            int cx = poll[1];

            if (cy == desY && cx == desX) {
                return;
            }

            for (int i = 0; i < 6; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }
                if (chess[ny][nx] >= chess[cy][cx]) {
                    continue;
                }

                queue.offer(new int[]{ny, nx});
                chess[ny][nx] = chess[cy][cx] + 1;
            }
        }
    }
}
// S1 데스 나이트 BFS
// 30분
// BFS 는 최초 방문이 최소 이동 횟수임을 반드시 보장
// 그리고 가중치가 반드시 동일하다
// 물결 플러드 필을 고려했을 때도 마찬가지
// 그래서 visit의 방문 여부 대신 chess 의 -1 로 초기화해서 시작을 0으로 해서 한다.