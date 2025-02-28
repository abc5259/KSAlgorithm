package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int[][] grid;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int res = 0; // 총 벌레 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            grid = new int[N][M];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 1) {
                        bfs(i, j);
                        res++;
//                        dfs(i, j);
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x) {
        grid[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < N && nx < M && grid[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        grid[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int py = arr[0];
            int px = arr[1];

            for (int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && grid[ny][nx] == 1) {
                    grid[ny][nx] = 0;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}

// S2 유기농 배추 DFS
// 일단 단지와 비슷하지만 사방으로 안연결되어있는 것은 벌레가 또먹어야 한다 == dfs를 또 돌려야한다
// 그래서 이를 구하기 위해 dfs 실행마다의 갯수를 구하고 dfs는 1이었던 배추자리를 0으로 만들어서
// 탐색여부를 판별한다.

// bfs로도 풀어봤다 queue를 이용해서 queue가 빌 때까지그리고 delta를 쓰고 반복문이 재귀가 아닌 queue에 넣는 방식이다.