package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11123 {
    static int H, W;
    static boolean[][] grid, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            grid = new boolean[H][W];
            visit = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    if (line.charAt(j) == '#') {
                        grid[i][j] = true;
                    }
                }
            }

            int size = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] && !visit[i][j]) {
                        bfs(i, j);
                        size++;
                    }
                }
            }
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int cy = poll[0];
            int cx = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx] || !grid[ny][nx]) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
// S2 양 한마리... 양 두마리... BFS
// 9분
// 그냥 풀었다.
// 커넥티드 컴포넌트로 완탐 돌려서 거기서 이어져있는 것들의 개수 즉 섬의 개수와 같은 맥락
// DFS 로 가나 BFS 로 가나 똑같은 풀이 법이다 그래서 BFS 로 구현했고
// size 값 반환하고 시간복잡도가 다 100이어서
// O(100 * 100 * 100) 이라 생각 BFS 라.