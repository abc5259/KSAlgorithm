package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[][] grid;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(grid[N - 1][M - 1]);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs(int y, int x) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int py = arr[0];
            int px = arr[1];

            for (int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];
                if (ny >= 0 && nx >= 0 && nx < M && ny < N && grid[ny][nx] == 1) {
                    grid[ny][nx] = grid[py][px] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}

// S1 미로 탐색 BFS
// 최단거리이기에 BFS를 사용 DFS를 썻더니 스택 오버 플로우 발생 왜냐면 비교하면서 내려가기 때문에
// 다른 방향에서 온 친구가 더 적으면 걔를 차용해야하는데 재귀에서 스택 오버 플로우 발생
// BFS는 가볍게 일단 방문여부는 grid의 배열로 확인할 수있엇고,
// ny nx 이것이 중요하다 이것으로 초기화 해야되니까 앞으로 그냥 바꿔서 풀어야겠다.
// 그리고 누적합이라서 poll 된 배열의 값에서 +1씩하면된다.