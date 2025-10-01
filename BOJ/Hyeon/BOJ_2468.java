package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int N;
    static int[][] area;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];

        int min = 0, max = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }

        int res = 0;
        for (int i = min; i < max; i++) {
            visit = new boolean[N][N];
            int cnt = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visit[y][x] && area[y][x] > i) {
                        bfs(y, x, i);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.print(res);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int y, int x, int height) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                    continue;
                }
                if (area[ny][nx] <= height) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
// S1 안전 영역 BFS
// 15분
// 일단 2차원 그리드로 주어졌고 min 부터 max 까지의 물높이 마다 bfs를 돌리는게 핵심 그래서
// 수위마다 visit 배열을 만들어서 반복문해야되는데 n이 100까지이고  높이도 100까지라서
// 시간복잡도는 100^3이었다 그래서 괜찮았다
// 그리고 bfs 를 돌리고 수위까지 인수로 같이 넣어줘서 비교해서 continue 로 판단했다